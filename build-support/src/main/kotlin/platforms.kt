import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetWithHostTests

fun KotlinMultiplatformExtension.createSvgoKtPlatforms(): List<KotlinNativeTargetWithHostTests> {
    val macosTargets = listOf(
        macosArm64(),
        macosX64(),
        )
    val linuxTargets = listOf(
        linuxX64(),
        )
    val windowsTargets = listOf(
        mingwX64(),
        )

    return macosTargets + linuxTargets + windowsTargets
}
