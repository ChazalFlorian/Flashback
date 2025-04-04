import com.android.build.gradle.LibraryExtension
import com.fchazal.flashback.build_logic.convention.configureKotlinAndroid
import com.fchazal.flashback.build_logic.convention.implementation
import com.fchazal.flashback.build_logic.convention.libs
import com.fchazal.flashback.build_logic.convention.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 34
            }

            dependencies {
                implementation(libs.findBundle("coroutines").get())
                testImplementation(kotlin("test"))
            }
        }
    }
}
