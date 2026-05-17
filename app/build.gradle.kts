import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(localPropertiesFile.inputStream())
}

val geminiApiKey = localProperties.getProperty("GEMINI_API_KEY") ?: "YOUR_API_KEY"

android {
    namespace = "com.example.nammashasane"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nammashasane"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        buildConfigField("String", "GEMINI_API_KEY", "\"$geminiApiKey\"")
    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {

        sourceCompatibility =
            JavaVersion.VERSION_17

        targetCompatibility =
            JavaVersion.VERSION_17
    }

    kotlinOptions {

        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {

        kotlinCompilerExtensionVersion =
            "1.5.14"
    }
}

dependencies {

    // CORE

    implementation(
        "androidx.core:core-ktx:1.13.1"
    )

    implementation(
        "androidx.lifecycle:lifecycle-runtime-ktx:2.8.3"
    )

    implementation(
        "androidx.activity:activity-compose:1.9.0"
    )

    // COMPOSE

    implementation(
        "androidx.compose.ui:ui:1.6.8"
    )

    implementation(
        "androidx.compose.material3:material3:1.2.1"
    )

    implementation(
        "androidx.compose.material:material-icons-extended"
    )

    implementation(
        "androidx.compose.ui:ui-tooling-preview:1.6.8"
    )

    debugImplementation(
        "androidx.compose.ui:ui-tooling:1.6.8"
    )

    // NAVIGATION

    implementation(
        "androidx.navigation:navigation-compose:2.7.7"
    )

    // GEMINI AI

    implementation(
        "com.google.ai.client.generativeai:generativeai:0.9.0"
    )

    // ROOM DATABASE

    implementation(
        "androidx.room:room-runtime:2.6.1"
    )

    implementation(
        "androidx.room:room-ktx:2.6.1"
    )

    kapt(
        "androidx.room:room-compiler:2.6.1"
    )

    // GOOGLE AUTH
    implementation("com.google.android.gms:play-services-auth:21.2.0")

    // IMAGE LOADING
    implementation("io.coil-kt:coil-compose:2.6.0")

    // GOOGLE MAPS

    implementation(
        "com.google.android.gms:play-services-maps:18.2.0"
    )

    // RETROFIT

    implementation(
        "com.squareup.retrofit2:retrofit:2.9.0"
    )

    implementation(
        "com.squareup.retrofit2:converter-gson:2.9.0"
    )

    // CAMERAX

    implementation(
        "androidx.camera:camera-camera2:1.3.4"
    )

    implementation(
        "androidx.camera:camera-lifecycle:1.3.4"
    )

    implementation(
        "androidx.camera:camera-view:1.3.4"
    )
}