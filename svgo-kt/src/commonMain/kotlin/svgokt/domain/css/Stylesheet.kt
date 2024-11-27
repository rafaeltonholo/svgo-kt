package svgokt.domain.css

import svgokt.domain.XastElement
import svgokt.domain.XastParent

data class Specificity(
    val a: Int,
    val b: Int,
    val c: Int,
) {
    operator fun get(index: Int): Int = when (index) {
        0 -> a
        1 -> b
        2 -> c
        else -> throw IndexOutOfBoundsException("Index $index is out of bounds.")
    }
}

data class Stylesheet(
    val rules: List<StylesheetRule>,
    val parents: Map<XastElement, XastParent>
)

data class StylesheetDeclaration(
    val name: String,
    val value: String,
    val important: Boolean
)

data class StylesheetRule(
    val dynamic: Boolean,
    val selector: String,
    val specificity: Specificity,
    val declarations: List<StylesheetDeclaration>
)

sealed interface ComputedStyles {
    data class StaticStyle(
        val inherited: Boolean,
        val value: String
    ) : ComputedStyles

    data class DynamicStyle(
        val inherited: Boolean
    ) : ComputedStyles
}
