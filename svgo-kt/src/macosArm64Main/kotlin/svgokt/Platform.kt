package svgokt

actual fun getPlatform(): Platform = object : Platform {
    override val name: String = "Macos Arm64"
}
