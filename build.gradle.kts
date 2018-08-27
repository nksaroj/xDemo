// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.setValue
import org.gradle.kotlin.dsl.repositories

buildscript {
    repositories {

        maven(url = "https://maven.fabric.io/public")
        maven(url = "https://jitpack.io")
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "https://maven.google.com")
        mavenCentral()
        jcenter()
        google()
    }
    dependencies {

        classpath("com.android.tools.build:gradle:3.2.0-rc02")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.61")


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task("clean") {
    delete(rootProject.buildDir)
}