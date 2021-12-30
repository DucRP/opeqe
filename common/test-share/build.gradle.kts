import dependencies.Libs
import dependencies.Libs.DependencyInjection
import dependencies.Test
import dependencies.Test.Mockk

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
    implementation(Libs.material)

    Libs.Kotlin.run {
        implementation(kotlin_stdlib)
        Libs.Kotlin.Coroutine.run {
            implementation(test)
        }
    }
    //Android ->Tools
    Libs.AndroidX.run {
        implementation(extensionsCore)
        implementation(constraintLayout)
    }

    //Android->Fragment
    Libs.AndroidX.Fragment.run {
        implementation(fragmentKtx)
        implementation(fragment)
        implementation(test)
        debugImplementation(test) {
            exclude("androidx.test", "monitor")
        }
    }

    Libs.AndroidX.LifeCycle.run {
        implementation(liveData)
        implementation(viewModel)
        implementation(lifecycle_extensions)
        implementation(runtime)
        implementation(commonJava8)
    }
    Test.run {
        implementation(Mockk.mockk)
        implementation(junit)
    }
    DependencyInjection.Dagger.run {
        implementation(runtime)
        implementation(android)
        implementation(android_support)
    }
}