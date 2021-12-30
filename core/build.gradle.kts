import dependencies.Libs
import dependencies.Libs.DependencyInjection.Dagger
import dependencies.Tools


plugins {
    GradlePluginId.apply {
        id(ANDROID_LIBRARY)
        id(KOTLIN_ANDROID)
        id(PARCELIZE)
        id(KOTLIN_KAPT)

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

            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://randomuser.me/\""
            )
            buildConfigField("String", "DATABASE_NAME", "\"messenger\"")
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


    implementation(project(Modules.Common.THREAD))
    implementation(project(Modules.Common.DI))
    implementation(project(Modules.DATA))

    implementation(Libs.AndroidX.Room.core)
    implementation(Libs.AndroidX.paging)
    implementation(Libs.Network.OkHttp.core)
    implementation(Libs.Network.OkHttp.logger)
    implementation(Libs.Network.Retrofit.core)
    implementation(Libs.Network.Retrofit.gsonConverter)

    Libs.AndroidX.LifeCycle.run {
        implementation(commonJava8)
        implementation(liveData)
        implementation(runtime)
        implementation(viewModel)
    }
    implementation(Libs.AndroidX.extensionsCore)
    implementation(Libs.Kotlin.kotlin_stdlib)
    implementation(Libs.AndroidX.LifeCycle.lifecycle_extensions)
    implementation(Libs.Kotlin.Coroutine.core)
    implementation(Libs.Kotlin.Coroutine.android)
    implementation(Libs.Stetho.okHttp)
    implementation(Libs.Stetho.core)

    kapt(Libs.AndroidX.Room.compiler)
    Dagger.run {
        implementation(android)
        kapt(compiler)
    }
    Libs.AndroidX.DataStore.run {
        implementation(core)
        implementation(preferences)
    }
    implementation(Tools.APP_AUTH)

}