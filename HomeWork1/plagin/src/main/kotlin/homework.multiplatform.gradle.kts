import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

val catalog = extensions
    .getByType<VersionCatalogsExtension>()
    .named("libs")

kotlin {
    jvm()
    js {
        nodejs()
    }
    jvmToolchain(
        catalog.findVersion("jvm").get().requiredVersion.toInt()
    )
}
