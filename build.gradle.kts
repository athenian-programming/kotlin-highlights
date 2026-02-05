plugins {
  java
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.versions)
}

group = "org.athenian"
version = "1.0-SNAPSHOT"

repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation(libs.ktor.server)
  implementation(libs.ktor.server.cio)
  implementation(libs.ktor.server.sessions)
  implementation(libs.ktor.server.html.builder)
  implementation(libs.kotlin.logging)
  implementation(libs.logback.classic)
  implementation(libs.slf4j.jul)
}

kotlin {
  jvmToolchain(17)
}

tasks.compileKotlin {
  compilerOptions {
    freeCompilerArgs.addAll(
      "-opt-in=kotlin.time.ExperimentalTime",
      "-opt-in=kotlinx.serialization.UnstableDefault"
    )
  }
}

tasks.compileTestKotlin {
  compilerOptions {
    freeCompilerArgs.addAll(
      "-opt-in=kotlin.time.ExperimentalTime",
      "-opt-in=kotlinx.serialization.UnstableDefault"
    )
  }
}
