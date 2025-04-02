import com.fchazal.flashback.build_logic.convention.implementation

plugins {
    alias(libs.plugins.flashback.android.library)
    alias(libs.plugins.flashback.android.library.compose)
}

android {
    namespace = "com.fchazal.core.ui"
}

dependencies {
    implementation(libs.bundles.lottie)
}