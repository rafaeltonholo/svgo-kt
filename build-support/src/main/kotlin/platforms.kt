import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetWithHostTests
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl

fun KotlinMultiplatformExtension.createSvgoKtNativePlatforms(): List<KotlinNativeTargetWithHostTests> {
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

fun KotlinMultiplatformExtension.createJsPlatform(moduleName: String): KotlinJsTargetDsl = js {
    this.moduleName = moduleName
    binaries.executable()
    nodejs()
    browser {
        commonWebpackConfig {
            outputFileName = "$moduleName.js"
        }
    }
}
