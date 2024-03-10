plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
}

group = "org.torrentloom"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // CLI Parser
    implementation("com.github.ajalt.clikt:clikt:4.2.2")
    // Dependency Injection
    implementation("io.insert-koin:koin-core:3.5.3")
    // JSon Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")


    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
