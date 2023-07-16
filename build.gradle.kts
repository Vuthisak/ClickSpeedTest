// Top-level build file where you can add configuration options common to all sub-projects/modules

buildscript {
    val rxAndroidVersion = "3.0.2"
    val rxJavaVersion = "3.1.5"
    val rxAndroidDeb by extra("io.reactivex.rxjava3:rxandroid:$rxAndroidVersion")
    val rxJavaDeb by extra("io.reactivex.rxjava3:rxjava:$rxJavaVersion")
}

plugins {
    id("com.android.application") version "8.1.0-beta01" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "8.1.0-beta01" apply false
}
