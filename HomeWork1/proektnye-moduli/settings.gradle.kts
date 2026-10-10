pluginManagement {
    includeBuild("../plagin")
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "proektnye-moduli"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

include(":domain-jvm")
include(":shared-kmp")
