package saxkt.extensions

object SaxExtensions {
    fun Char.isSaxWhitespace() = this == ' ' || this == '\n' || this == '\r' || this == '\t'
    fun Char.isQuote() = this == '"' || this == '\''
    fun Char.isAttributeEnd() = this == '>' || isSaxWhitespace()
    fun Char.isMatch(regex: Regex): Boolean = regex.matches(toString())
    fun Char.isNotMatch(regex: Regex): Boolean = regex.matches(toString()).not()
}
