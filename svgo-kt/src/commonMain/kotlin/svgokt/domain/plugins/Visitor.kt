package svgokt.domain.plugins

import svgokt.domain.XastCdata
import svgokt.domain.XastComment
import svgokt.domain.XastDoctype
import svgokt.domain.XastElement
import svgokt.domain.XastInstruction
import svgokt.domain.XastNode
import svgokt.domain.XastParent
import svgokt.domain.XastRoot
import svgokt.domain.XastText

sealed interface VisitState {
    data object Skip : VisitState
    data object Continue : VisitState
}

data class VisitorNode<in T : XastNode>(
    val onEnter: ((node: T, parentNode: XastParent?) -> VisitState)? = null,
    val onExit: ((node: T, parentNode: XastParent?) -> Unit)? = null,
)

typealias VisitorRoot = VisitorNode<XastRoot>

data class Visitor(
    val doctype: VisitorNode<XastDoctype>? = null,
    val instruction: VisitorNode<XastInstruction>? = null,
    val comment: VisitorNode<XastComment>? = null,
    val cdata: VisitorNode<XastCdata>? = null,
    val text: VisitorNode<XastText>? = null,
    val element: VisitorNode<XastElement>? = null,
    val root: VisitorRoot? = null,
) {
    /**
     * Gets the visitor property based on the nodes type
     * @suppress UNCHECKED_CAST since we know that T is going to be
     * the expected type, otherwise we return null.
     */
    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : XastNode> get(node: T): VisitorNode<T>? = when (node::class) {
        XastDoctype::class -> doctype
        XastInstruction::class -> instruction
        XastComment::class -> comment
        XastCdata::class -> cdata
        XastText::class -> text
        XastElement::class -> element
        XastRoot::class -> root
        else -> null
    } as? VisitorNode<T>?
}
