// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    project.extra.set("compileSdk", 34)
    project.extra.set("targetSdk", 34)
    project.extra.set("minSdk", 24)
    project.extra.set("versionCode", 1000)
    project.extra.set("versionName", "0.01.000")
    project.extra.set("javaVersion", JavaVersion.VERSION_18)
    project.extra.set("jvmTarget", "18")
    project.extra.set("kotlinCompilerExtensionVersion", "1.5.1")

    dependencies {
        classpath(libs.hiltAndroidGradlePlugin)
    }
    repositories {
        google()
    }
}
plugins {
    alias(libs.plugins.application) apply false
    alias(libs.plugins.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.hilt) apply false
}
