plugins {
    id("homework.jvm")
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("org.example.MainKt")
}

val myCustomTask = tasks.register("myCustomTask") {
    group = "lesson"
    description = "Generates a Kotlin source file with the module version"

    val moduleVersion = project.version.toString()
    val outputDirectory = layout.buildDirectory.dir("my-in")
    inputs.property("moduleVersion", moduleVersion)
    outputs.dir(outputDirectory)

    doLast {
        val outputFile = outputDirectory.get().file("my-version.kt").asFile
        outputFile.parentFile.mkdirs()
        outputFile.writeText(
            """
            package my.x

            const val MY_VERSION: String = "$moduleVersion"
            """.trimIndent() + "\n"
        )
    }
}

val myCopyTask = tasks.register<Copy>("myCopyTask") {
    group = "lesson"
    description = "Copies the generated Kotlin source file"
    from(myCustomTask)
    into(layout.buildDirectory.dir("tmp/my-version"))
}

kotlin.sourceSets.named("main") {
    kotlin.srcDir(myCustomTask)
}

tasks.named("compileKotlin") {
    dependsOn(myCopyTask)
}
