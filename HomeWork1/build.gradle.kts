plugins {
    base
}

val verifyHomework by tasks.registering {
    group = "verification"
    description = "Assembles plugins and compiles homework modules"

    dependsOn(
        gradle.includedBuild("plagin").task(":assemble"),
        gradle.includedBuild("uchebnye-moduli").task(":assemble"),
        gradle.includedBuild("proektnye-moduli").task(":assemble")
    )
}

tasks.named("assemble") {
    dependsOn(verifyHomework)
}
