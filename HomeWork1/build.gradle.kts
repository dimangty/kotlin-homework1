plugins {
    base
}

val homeworkBuilds = listOf("plagin", "uchebnye-moduli", "proektnye-moduli")

tasks.named("assemble") {
    dependsOn(homeworkBuilds.map { gradle.includedBuild(it).task(":assemble") })
}

tasks.named("check") {
    dependsOn(homeworkBuilds.map { gradle.includedBuild(it).task(":check") })
}

tasks.register("verifyHomework") {
    group = "verification"
    description = "Assembles and checks all homework builds"
    dependsOn(tasks.named("build"))
}
