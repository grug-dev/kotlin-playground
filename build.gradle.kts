plugins {
    kotlin("jvm") version "1.9.22" apply false
    id("org.jetbrains.kotlinx.kover") version "0.9.11"
}

// Kover needs its JVM agent from Maven Central in the root project too.
repositories {
    mavenCentral()
}

// The root merges the coverage of every module into one report.
dependencies {
    kover(project(":algorithms"))
    kover(project(":leetcode"))
}
