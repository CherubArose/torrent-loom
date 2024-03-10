plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
    application
}

group = "org.torrentloom"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.clikt)
    implementation(libs.koin)
    implementation(libs.kotlinxSerialization)
    implementation(libs.kommand)
    implementation(libs.kotlinLogging)

    runtimeOnly(libs.slf4j)

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("org.torrentloom.MainKt")
}
