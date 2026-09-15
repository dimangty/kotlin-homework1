pluginManagement {
    val kotlinVersion = providers.gradleProperty("kotlinVersion").get()

    plugins {
        kotlin("jvm") version kotlinVersion
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "HomeWork1"
include("submodule")
