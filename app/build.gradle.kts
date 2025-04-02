import com.fchazal.flashback.build_logic.convention.implementation

plugins {
    alias(libs.plugins.flashback.android.application)
    alias(libs.plugins.flashback.android.application.compose)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.fchazal.flashback"

    defaultConfig {
        applicationId = "com.fchazal.flashback"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.navigation)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.lottie)
    implementation(libs.koin.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}