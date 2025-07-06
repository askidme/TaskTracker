plugins {
    kotlin("multiplatform") version "1.9.10"
    kotlin("plugin.serialization") version "1.9.10"
    id("com.android.library")
}

repositories {
    google()
    mavenCentral()
}

kotlin {
    androidTarget()

    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
            }
        }
        val androidMain by getting
        val jsMain by getting
    }
}
