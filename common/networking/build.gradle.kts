import dependencies.Libs


plugins {
    GradlePluginId.apply {
        id(ANDROID_LIBRARY)
        id(KOTLIN_ANDROID)
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
        android.buildFeatures.dataBinding = true
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
    implementation(project(Modules.DATA))
    implementation(Libs.Network.Retrofit.core)
    implementation(Libs.Network.Retrofit.gsonConverter)
}