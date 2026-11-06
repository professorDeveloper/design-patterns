plugins {
    kotlin("jvm")
    application
}

group = "uz.azamov.smartcity"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    // Ildiz loyiha bilan bir xil toolchain
    jvmToolchain(25)
}

application {
    mainClass = "uz.azamov.smartcity.MainKt"
}

tasks.test {
    useJUnitPlatform()
}
