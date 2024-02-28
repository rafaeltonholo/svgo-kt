package svgokt.plugins.xast

import svgokt.domain.XastNode
import svgokt.domain.XastParent

fun XastNode.detachFromParent(parentNode: XastParent) {
    parentNode.children.remove(this)
}
