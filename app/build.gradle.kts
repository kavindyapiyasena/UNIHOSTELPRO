plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.abc.myappunihstel"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.abc.myappunihstel"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // ✅ ZXing QR Scanner
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")

    // ✅ Google Maps SDK
    implementation("com.google.android.gms:play-services-maps:19.0.0")

    // ✅ Biometric Authentication
    implementation("androidx.biometric:biometric:1.1.0")
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // ✅ Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
