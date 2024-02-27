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

data class VisitorNode<T : XastNode>(
    val onEnter: ((node: T, parentNode: XastParent) -> Any/* symbol? */)? = null,
    val onExit: ((node: T, parentNode: XastParent) -> Unit)? = null,
)

data class VisitorRoot(
    val onEnter: ((node: XastRoot, parentNode: XastParent) -> Unit)? = null,
    val onExit: ((node: XastRoot, parentNode: XastParent) -> Unit)? = null,
) // May not be needed.

data class Visitor(
    val doctype: VisitorNode<XastDoctype>? = null,
    val instruction: VisitorNode<XastInstruction>? = null,
    val comment: VisitorNode<XastComment>? = null,
    val cdata: VisitorNode<XastCdata>? = null,
    val text: VisitorNode<XastText>? = null,
    val element: VisitorNode<XastElement>? = null,
    val root: VisitorRoot? = null,
)
