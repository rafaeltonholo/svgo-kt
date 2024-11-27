package svgokt.style

import svgokt.domain.XastElement
import svgokt.domain.css.ComputedStyles
import svgokt.domain.css.Stylesheet

fun computeOwnStyle(stylesheet: Stylesheet, node: XastElement): ComputedStyles {
    val importantStyles = mutableMapOf<String, String>()
    // collect attributes
    for ((name, value) in node.attributes) {

    }

    return ComputedStyles.DynamicStyle() // TODO
}
fun computeStyle(stylesheet: Stylesheet, node: XastElement): ComputedStyles {
    val (_, parents) = stylesheet
    val computedStyles = computeOwnStyle(stylesheet, node)
}
