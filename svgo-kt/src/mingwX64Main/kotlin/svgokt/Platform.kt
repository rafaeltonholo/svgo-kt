package svgokt

actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "Windows x64"
}
