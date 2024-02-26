package saxkt.domain

data class SaxNamespace(
    val bag: Map<String, String>,
) : Map<String, String> by bag {
    companion object {
        operator fun invoke(
            vararg pairs: Pair<String, String>,
        ) = SaxNamespace(mapOf(*pairs)).also { println("NS=$it") }
    }
}
