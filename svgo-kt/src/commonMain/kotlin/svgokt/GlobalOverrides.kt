package svgokt

object GlobalOverrides {
    var floatPrecision: Int? = null

    fun toMap(): Map<String, Any> = buildMap {
        floatPrecision?.let { put("floatPrecision", it) }
    }
}
