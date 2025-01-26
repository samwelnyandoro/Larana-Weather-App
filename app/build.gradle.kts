plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.weatherapp.weatherapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.weatherapp.weatherapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "OPENWEATHERMAP_BASEURL", "\"${project.findProperty("OPENWEATHERMAP_BASEURL") ?: ""}\"")
            buildConfigField("String", "OPENWEATHERMAP_API_KEY", "\"${project.findProperty("OPENWEATHERMAP_API_KEY") ?: ""}\"")
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "OPENWEATHERMAP_BASEURL", "\"${project.findProperty("OPENWEATHERMAP_BASEURL") ?: ""}\"")
            buildConfigField("String", "OPENWEATHERMAP_API_KEY", "\"${project.findProperty("OPENWEATHERMAP_API_KEY") ?: ""}\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.analytics)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    implementation (libs.sdp.android)
    implementation (libs.ssp.android)
    // Coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    // Picasso
    implementation(libs.picasso)
    // BarChart
    implementation(libs.mpandroidchart)
    // Location
    implementation(libs.play.services.location)
}