import org.gradle.api.artifacts.VersionCatalogsExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsEnvSpec
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootEnvSpec

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

val catalog = extensions
    .getByType<VersionCatalogsExtension>()
    .named("libs")

// Included builds can install JS tools concurrently, so each build owns its cache.
val jsToolingDirectory = rootProject.layout.projectDirectory.dir(".gradle/kotlin-js")

rootProject.plugins.withType<NodeJsPlugin> {
    rootProject.extensions.configure<NodeJsEnvSpec> {
        installationDirectory.set(jsToolingDirectory.dir("nodejs"))
    }
}

plugins.withType<NodeJsPlugin> {
    extensions.configure<NodeJsEnvSpec> {
        installationDirectory.set(jsToolingDirectory.dir("nodejs"))
    }
}

rootProject.plugins.withType<YarnPlugin> {
    rootProject.extensions.configure<YarnRootEnvSpec> {
        installationDirectory.set(jsToolingDirectory.dir("yarn"))
    }
}

kotlin {
    jvm()
    js {
        nodejs()
    }
    jvmToolchain(
        catalog.findVersion("jvm").get().requiredVersion.toInt()
    )

    sourceSets {
        commonTest.dependencies {
            implementation(catalog.findLibrary("kotlin-test").get())
        }
    }
}
