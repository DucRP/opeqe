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
    Libs.AndroidX.DataStore.run {
        implementation(core)
        implementation(preferences)
    }
    //Dagger
    Dagger.run {
        implementation(runtime)
        implementation(android)
        implementation(android_support)
        kapt(compiler)
        kapt(android_support_compiler)
    }
    Dagger.Assisted.run {
        compileOnly(annotations)
        kapt(processor)
    }
    Modules.Common.run {
        implementation(project(DI))
        implementation(project(MAPPER))
        implementation(project(DATASOURCE))
    }

    implementation(Libs.timber)
    implementation(Libs.AndroidX.Room.core)
    kapt(Libs.AndroidX.Room.compiler)
    implementation(Libs.AndroidX.LifeCycle.liveData)
    implementation(Libs.AndroidX.paging)
    implementation(Libs.Network.Retrofit.gsonConverter)
}