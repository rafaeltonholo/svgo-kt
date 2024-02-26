package svgokt.parser

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.launch
import saxkt.SaxParser
import saxkt.domain.SaxEvent
import saxkt.domain.options
import svgokt.SvgoParserException
import svgokt.domain.XastCdata
import svgokt.domain.XastChild
import svgokt.domain.XastComment
import svgokt.domain.XastDoctype
import svgokt.domain.XastElement
import svgokt.domain.XastElementType
import svgokt.domain.XastInstruction
import svgokt.domain.XastParent
import svgokt.domain.XastRoot
import svgokt.domain.XastText
import svgokt.plugins.Collections

private val options = options {
    strict = true
    trim = true
    normalize = false
    lowercase = false
    xmlns = true
    position = true
}
private val entityDeclaration = """<!ENTITY\s+(\S+)\s+(?:'([^']+)'|"([^"]+)")\s*>""".toRegex()

sealed interface ParseState {
    data object Parsing : ParseState
    data class Parsed(val root: XastRoot) : ParseState
}

/**
 * Convert SVG (XML) string to SVG-as-Object.
 * @param data the SVG content
 * @param from the file path
 */
suspend fun parseSvg(data: String, from: String?): XastRoot {
    val sax = SaxParser(strict = options.strict, options = options)
    val root = XastRoot(type = XastElementType.ROOT, children = mutableListOf())
    var current: XastParent = root
    val stack: MutableList<XastParent> = mutableListOf(root)

    fun pushToContent(node: XastChild) {
        current.children += node
    }

    MainScope().launch {
        sax.write(data).close()
    }

    sax.events
        .takeWhile { stack.isNotEmpty().also {
            if (!it) println("stack is empty. root = $root")
        } }
        .collect { event ->
//            println(event)
            // TODO remove legacy parentNode in v4
            val parentNode = current

            when (event) {
                is SaxEvent.Doctype -> {
                    val doctype = event.data
                    val node = XastDoctype(
                        // parentNode = parentNode,
                        name = "svg",
                        data = XastDoctype.XastDoctypeData(doctype)
                    )
                    pushToContent(node)
                    val subsetStart = doctype.indexOf("[")
                    if (subsetStart >= 0) {
                        var entityMatch = entityDeclaration.find(input = data, startIndex = subsetStart)
                        while (entityMatch != null) {
                            val matches = entityMatch.groupValues
                            sax.addToEntity(key = matches[1], value = matches[2].ifEmpty { matches[3] })
                            entityMatch = entityMatch.next()
                        }
                    }
                }

                is SaxEvent.ProcessingInstruction -> {
                    val node = XastInstruction(
                        name = event.name,
                        value = event.body,
                        // parentNode = parentNode,
                    )
                    pushToContent(node)
                }

                is SaxEvent.Comment -> {
                    val node = XastComment(
                        value = event.comment.trim(),
                        // parentNode = parentNode,
                    )
                    pushToContent(node)
                }

                is SaxEvent.Cdata -> {
                    val node = XastCdata(
                        value = event.value,
                        // parentNode = parentNode,
                    )
                    pushToContent(node)
                }

                is SaxEvent.OpenTag -> {
                    val element = XastElement(
                        // parentNode = parentNode,
                        name = event.tag.name,
                        attributes = event.tag.attributes.mapValues { (_, value) -> value.value.toString() },
                        children = mutableListOf(),
                    )
                    pushToContent(element)
                    current = element
                    stack += element
                }

                is SaxEvent.Text -> (current as? XastElement)?.let { current ->
                    // prevent trimming of meaningful whitespace inside textual tags
                    if (Collections.textElements.contains(current.name)) {
                        val node = XastText(
                            value = event.textNode,
                            // parentNode = current,
                        )
                        pushToContent(node)
                    } else if ("\\S".toRegex().matches(event.textNode)) {
                        val node = XastText(
                            value = event.textNode.trim(),
                            // parentNode = current,
                        )
                        pushToContent(node)
                    }
                }

                is SaxEvent.CloseTag -> {
                    stack.removeLast()
                    stack.lastOrNull()?.let { current = it }
                }

                is SaxEvent.Error -> {
                    val error = SvgoParserException(
                        message = event.error.reason,
                        line = (event.error.positionTracker?.line ?: 0) + 1,
                        column = (event.error.positionTracker?.column ?: 0),
                        source = data,
                        file = from.orEmpty(),
                    )
                    if (error.message.contains("Unexpected end")) {
                        throw error
                    } else {
                        //println(error)
                    }
                }

                is SaxEvent.End -> println("root = ${root}")

                else -> Unit
            }
        }

    println("Does it ever drop here?")

    return root
}
