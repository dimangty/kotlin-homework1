plugins {
    base
    id("homework.jvm") apply false
    id("homework.multiplatform") apply false
}

tasks.named("assemble") {
    dependsOn(
        ":HomeWork1:assemble",
        ":lesson-mpp:assemble",
        ":lesson-mpp:compileKotlinJvm",
        ":lesson-mpp:compileKotlinJs"
    )
}
