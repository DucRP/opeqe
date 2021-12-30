import dependencies.Libs
import dependencies.Libs.DependencyInjection.Dagger

plugins {
    GradlePluginId.apply {
        id(ANDROID_LIBRARY)
        id(KOTLIN_ANDROID)
        id(PARCELIZE)
        id(KOTLIN_KAPT)
    }
}
kapt {
    correctErrorTypes = true
    useBuildCache = true

    javacOptions {
        option("-Xmaxerrs", 2000)
    }
}
android {
    GradleVersionConfig.apply {
        compileSdkVersion(COMPILE_SDK_VERSION)
        buildToolsVersion = BUILD_TOOLS_VERSION

        defaultConfig {
            minSdkVersion(MIN_SDK_VERSION)
            targetSdkVersion(TARGET_SDK_VERSION)
            versionCode = 1
            versionName = "1.0"
            testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
        }
        compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
        compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
        testOptions.animationsDisabled = true

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.AndroidX.LifeCycle.viewModel)
    implementation(Libs.AndroidX.Fragment.fragment)
    Dagger.run {
        implementation(android)
        kapt(android_support_compiler)
    }
    Dagger.Assisted.run {
        compileOnly(annotations)
        kapt(processor)
    }

}