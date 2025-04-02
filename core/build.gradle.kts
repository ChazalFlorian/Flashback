plugins {
    alias(libs.plugins.flashback.android.library)
    alias(libs.plugins.flashback.android.library.compose)
}

android {
    namespace = "com.fchazal.core"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}