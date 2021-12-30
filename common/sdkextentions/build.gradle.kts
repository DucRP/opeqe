import dependencies.Libs


plugins {
    GradlePluginId.apply {
        id(ANDROID_LIBRARY)
        id(KOTLIN_ANDROID)
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
    implementation(Libs.timber)
    implementation(Libs.material)
    implementation(Libs.AndroidX.Fragment.fragmentKtx)
    implementation(Libs.AndroidX.Fragment.fragment)
    implementation(Libs.AndroidX.LifeCycle.commonJava8)
    implementation(Libs.AndroidX.LifeCycle.liveData)
    implementation(Libs.AndroidX.extensionsCore)
    implementation(Libs.Kotlin.kotlin_stdlib)
    implementation(Libs.AndroidX.LifeCycle.lifecycle_extensions)
    implementation(Libs.AndroidX.Navigation.core)
    implementation(Libs.Kotlin.Coroutine.core)
    implementation(Libs.Kotlin.Coroutine.android)
    implementation(Libs.Glide.core)
    kapt(Libs.Glide.compiler)
}