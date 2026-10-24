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

    sourceSets {
        named("main") {
            kotlin.srcDir("src/jvmMain/kotlin")
        }
        named("test") {
            kotlin.srcDir("src/jvmTest/kotlin")
        }
    }
}

dependencies {
    testImplementation(catalog.findLibrary("kotlin-test").get())
}
