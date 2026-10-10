import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    id("org.jetbrains.kotlin.jvm")
    `java-library`
}

val catalog = extensions
    .getByType<VersionCatalogsExtension>()
    .named("libs")

kotlin {
    jvmToolchain(
        catalog.findVersion("jvm").get().requiredVersion.toInt()
    )
}
