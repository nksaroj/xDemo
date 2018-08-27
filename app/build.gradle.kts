import org.jetbrains.kotlin.config.KotlinCompilerVersion
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.DefaultConfig
import org.gradle.kotlin.dsl.*
import com.android.build.gradle.api.ApplicationVariant
import com.android.build.gradle.api.BaseVariantOutput
import com.android.build.gradle.internal.api.BaseVariantOutputImpl

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        multiDexEnabled = true
        applicationId = "sk.android.com.xdemo"

        minSdkVersion(15)
        targetSdkVersion(26)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"


    }


    buildTypes {

        getByName("debug") {
            multiDexEnabled = true
            isDebuggable = true
        }


        getByName("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            isUseProguard = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

        }

    }

}


dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //==================== Kotlin ====================
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.2.61")

    //==================== Support Library ============
    implementation("androidx.appcompat:appcompat:1.0.0-rc01")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-alpha2")


    compile("se.ansman.kotshi:api:1.0.4")
    kapt ("se.ansman.kotshi:compiler:1.0.4")


    //==================== Tests =====================
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.0-alpha4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.0-alpha4")



}
