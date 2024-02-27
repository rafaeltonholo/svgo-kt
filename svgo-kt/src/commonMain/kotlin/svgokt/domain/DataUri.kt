package svgokt.domain

import kotlin.jvm.JvmInline

@JvmInline
value class DataUri private constructor(val value: String) {
    companion object {
        val Base64 = "base64"
        val Enc = "enc"
        val UnEnc = "unenc"
    }
}
