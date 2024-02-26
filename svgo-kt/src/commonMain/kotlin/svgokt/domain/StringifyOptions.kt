package svgokt.domain

typealias EncodeEntityFn = (char: String) -> String
data class StringifyOptions(
    val doctypeStart: String?,
    val doctypeEnd: String?,
    val procInstStart: String?,
    val procInstEnd: String?,
    val tagOpenStart: String?,
    val tagOpenEnd: String?,
    val tagCloseStart: String?,
    val tagCloseEnd: String?,
    val tagShortStart: String?,
    val tagShortEnd: String?,
    val attrStart: String?,
    val attrEnd: String?,
    val commentStart: String?,
    val commentEnd: String?,
    val cdataStart: String?,
    val cdataEnd: String?,
    val textStart: String?,
    val textEnd: String?,
    val indent: Int?,
    val regEntities: Regex?,
    val regValEntities: Regex?,
    val encodeEntity: EncodeEntityFn?,
    val pretty: Boolean?,
    val useShortTags: Boolean?,
    val eol: EndOfLine?,
    val finalNewline: Boolean?,
)
