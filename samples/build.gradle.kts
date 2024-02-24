plugins {
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform)
}

kotlin {
    createSvgoKtPlatforms().forEach { target ->
        target.binaries {
            executable {
                entryPoint = "main"
                baseName = "svgo-kt-sample"
                debuggable = true
            }
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(projects.svgoKt)
        }
        nativeMain.dependencies {  }
    }
}
