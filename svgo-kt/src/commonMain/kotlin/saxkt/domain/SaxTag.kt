package saxkt.domain

data class SaxTag(
    val name: String,
    val attributes: Map<String, SaxAttribute>,
    val ns: SaxNamespace? = null,
    val prefix: String? = null,
    val local: String? = null,
    val uri: String? = null,
    val isSelfClosing: Boolean = false,
)
