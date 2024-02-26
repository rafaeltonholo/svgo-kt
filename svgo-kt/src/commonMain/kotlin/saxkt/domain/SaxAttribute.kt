package saxkt.domain

data class SaxAttribute(
    val name: String,
    val value: Any,
    val prefix: String = "",
    val local: String = "",
    val uri: String = "",
)
