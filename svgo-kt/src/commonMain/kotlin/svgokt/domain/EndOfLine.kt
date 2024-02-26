package svgokt.domain

value class EndOfLine private constructor(val value: String) {
    companion object {
        val LF = EndOfLine("lf")
        val CRLF = EndOfLine("crlf")
    }
}
