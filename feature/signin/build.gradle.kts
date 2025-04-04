plugins {
    alias(libs.plugins.flashback.android.library)
    alias(libs.plugins.flashback.android.library.compose)
    alias(libs.plugins.flashback.android.room)
}

android {
    namespace = "com.fchazal.feature.signin"
}

dependencies {
    implementation(libs.koin.android)
    implementation(libs.bundles.room)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}