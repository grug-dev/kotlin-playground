plugins {
    kotlin("jvm")
    id("org.jetbrains.kotlinx.kover")
}

group = "com.kkpa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    //ParameterizedTest
    testImplementation("org.junit.jupiter:junit-jupiter-params:6.1.3")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}