package svgokt.plugins.xast

import svgokt.domain.XastElement
import svgokt.domain.XastNode
import svgokt.domain.XastParent
import svgokt.domain.XastRoot
import svgokt.domain.plugins.VisitState
import svgokt.domain.plugins.Visitor

fun XastNode.visit(visitor: Visitor, parentNode: XastParent? = null) {
    val callbacks = visitor.get(node = this)
    if (callbacks != null) {
        val visitState = callbacks.onEnter?.invoke(this, parentNode)
        if (visitState == VisitState.Skip) {
            return
        }
    }

    // visit root children
    if (this is XastRoot) {
        // copy the children's array to not loose cursor when children's array is spliced
        val currentChildren = children.toList()
        for (child in currentChildren) {
            child.visit(visitor, parentNode = this)
        }
    }

    // visit element children if still attached to parent
    if (this is XastElement) {
        if (parentNode?.children?.contains(this) == true) {
            // copy the children's array to not loose cursor when children's array is spliced
            val currentChildren = children.toList()
            for (child in currentChildren) {
                child.visit(visitor, parentNode = this)
            }
        }
    }
    callbacks?.onExit?.invoke(this, parentNode)
}
