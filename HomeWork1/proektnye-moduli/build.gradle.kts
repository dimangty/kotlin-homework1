plugins {
    base
    id("homework.jvm") apply false
    id("homework.multiplatform") apply false
}

tasks.named("assemble") {
    dependsOn(
        ":domain-jvm:assemble",
        ":shared-kmp:assemble"
    )
}

tasks.named("check") {
    dependsOn(
        ":domain-jvm:check",
        ":shared-kmp:check"
    )
}
