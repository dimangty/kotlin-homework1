pluginManagement {
    includeBuild("../plagin")
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "uchebnye-moduli"

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

include(":HomeWork1")
include(":lesson-mpp")
