package saxkt.domain

sealed interface SaxEvent {
    data class Text(val textNode: String) : SaxEvent
    data class ProcessingInstruction(
        val name: String,
        val body: String,
    ) : SaxEvent

    data class SgmlDeclaration(val declaration: String) : SaxEvent
    data class Doctype(val data: String) : SaxEvent
    data class Comment(val comment: String) : SaxEvent
    data class OpenTagStart(val tag: SaxTag) : SaxEvent
    data class Attribute(val attribute: SaxAttribute) : SaxEvent
    data class OpenTag(val tag: SaxTag) : SaxEvent
    data class CloseTag(val tagName: String) : SaxEvent
    data object OpenCdata : SaxEvent
    data class Cdata(val value: String) : SaxEvent
    data object CloseCdata : SaxEvent
    data class Error(val error: SaxError) : SaxEvent
    data object End : SaxEvent
    data object Ready : SaxEvent
    data class Script(val value: String) : SaxEvent
    data class OpenNamespace(val prefix: String, val uri: String) : SaxEvent
    data class CloseNamespace(val prefix: String, val uri: String) : SaxEvent
}
