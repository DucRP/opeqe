import dependencies.Libs

plugins {
    GradlePluginId.apply {
        id(ANDROID_LIBRARY)
        id(KOTLIN_ANDROID)
        id(PARCELIZE)
        id(KOTLIN_KAPT)
        id(NAVIGATION_SAFEARGS_KOTLIN)
    }
}
android {
    GradleVersionConfig.apply {
        buildToolsVersion = BUILD_TOOLS_VERSION
        compileSdkVersion(COMPILE_SDK_VERSION)
        defaultConfig {
            minSdkVersion(MIN_SDK_VERSION)
            targetSdkVersion(TARGET_SDK_VERSION)
            versionCode = 1
            versionName = "1.0"
        }
    }
    buildFeatures.viewBinding = true
    compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
    compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(Modules.DATA))
    implementation(Libs.material)
    Libs.AndroidX.run {
        implementation(swiperefreshlayout)
        implementation(extensionsCore)
    }
    Libs.Scale.run {
        implementation(sdp)
        implementation(ssp)
    }
    Libs.AndroidX.Navigation.run {
        implementation(core)
        implementation(uiKtx)
        implementation(ui)
        implementation(fragment)
        debugImplementation(test)
    }

}
