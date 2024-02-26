package saxkt.domain

data class SaxOptions(
    val strict: Boolean = false,
    val trim: Boolean = false,
    val normalize: Boolean = false,
    val lowercase: Boolean = false,
    val xmlns: Boolean = false,
    val position: Boolean = false,
    val noScript: Boolean = false,
    val strictEntities: Boolean = false,
)

@DslMarker
annotation class SaxOptionsDsl

@SaxOptionsDsl
class SaxOptionsBuilder {
    var strict: Boolean = false
    var trim: Boolean = false
    var normalize: Boolean = false
    var lowercase: Boolean = false
    var xmlns: Boolean = false
    var position: Boolean = false
    var noScript: Boolean = false
    var strictEntities: Boolean = false

    fun build(): SaxOptions = SaxOptions(
        strict = strict,
        trim = trim,
        normalize = normalize,
        lowercase = lowercase,
        xmlns = xmlns,
        position = position,
        noScript = noScript,
        strictEntities = strictEntities,
    )
}

fun options(block: SaxOptionsBuilder.() -> Unit): SaxOptions =
    SaxOptionsBuilder().apply(block).build()
