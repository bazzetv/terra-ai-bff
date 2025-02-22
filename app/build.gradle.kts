/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.12.1/userguide/building_java_projects.html in the Gradle documentation.
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.kotlin.jvm)
    id("io.ktor.plugin") version "2.3.0"
    kotlin("plugin.serialization") version "1.9.21"
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // 🚀 Ktor Core
    implementation("io.ktor:ktor-server-core:2.3.6")
    implementation("io.ktor:ktor-server-netty:2.3.6")

    // 🚀 Authentification & JWT (Stateless)
    implementation("io.ktor:ktor-server-auth:2.3.6")
    implementation("io.ktor:ktor-server-auth-jwt:2.3.6")
    implementation("org.mindrot:jbcrypt:0.4")

    // 🚀 Gestion des requêtes HTTP (Client & Server)
    implementation("io.ktor:ktor-server-content-negotiation:2.3.6")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")
    implementation("io.ktor:ktor-client-core:2.3.6")
    implementation("io.ktor:ktor-client-cio:2.3.6") // HTTP Client pour appeler des APIs externes

    // 🚀 CORS (Cross-Origin Requests) si tu appelles ton API depuis un frontend
    implementation("io.ktor:ktor-server-cors:2.3.6")

    // 🚀 Logging avec Logback
    implementation("ch.qos.logback:logback-classic:1.4.14")

    // 🚀 Gestion des Bases de Données (Exposed + PostgreSQL)
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.41.1") // Support des dates
    implementation("org.postgresql:postgresql:42.5.1") // Driver PostgreSQL
    implementation("com.zaxxer:HikariCP:5.0.1") // Gestion des connexions DB avec HikariCP

    // 🚀 JSON Parsing
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    // 🚀 Database
    implementation("org.flywaydb:flyway-core:9.22.1") // Ajoute la dernière version de Flyway
    implementation("org.postgresql:postgresql:42.5.4") // Assure-toi d’avoir le driver PostgreSQL
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use Kotlin Test test framework
            useKotlinTest("2.0.21")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "com.terra.bff.application.ApplicationKt"
}
