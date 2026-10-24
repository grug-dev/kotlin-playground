plugins {
    kotlin("jvm") version "1.9.22" apply false
    id("org.jetbrains.kotlinx.kover") version "0.9.9"
}

// The root merges the coverage of every module into one report.
dependencies {
    kover(project(":algorithms"))
    kover(project(":leetcode"))
}
