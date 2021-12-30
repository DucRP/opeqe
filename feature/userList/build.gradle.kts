    import Modules.DESIGN_SYSTEM
    import dependencies.Libs
import dependencies.Libs.DependencyInjection.Dagger
import dependencies.Test
import dependencies.Test.Mockk
import dependencies.Tools


plugins {
    GradlePluginId.apply {
        id(ANDROID_LIBRARY)
        id(KOTLIN_ANDROID)
        id(PARCELIZE)
        id(KOTLIN_KAPT)
        id(NAVIGATION_SAFEARGS_KOTLIN)
    }
}

kapt {
    correctErrorTypes = true
    useBuildCache = true

    javacOptions {
        option("-Xmaxerrs", 2000)
    }
}
configurations.all {
    resolutionStrategy {
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
    }
}
android {
    GradleVersionConfig.apply {
        packagingOptions.exclude(PackagingOptions.DEPENDENCIES)
        packagingOptions.exclude(PackagingOptions.LICENSE)
        packagingOptions.exclude(PackagingOptions.LICENSE_TEXT)
        packagingOptions.exclude(PackagingOptions.LICENSE_TEXT_2)
        packagingOptions.exclude(PackagingOptions.NOTICE)
        packagingOptions.exclude(PackagingOptions.NOTICE_TEXT)
        packagingOptions.exclude(PackagingOptions.NOTICE_TEXT_2)
        packagingOptions.exclude(PackagingOptions.ASL2)
        packagingOptions.exclude(PackagingOptions.AL2)
        packagingOptions.exclude(PackagingOptions.KOTLIN)
        packagingOptions.exclude(PackagingOptions.LGPL2)

        compileSdkVersion(COMPILE_SDK_VERSION)
        buildToolsVersion = BUILD_TOOLS_VERSION
        defaultConfig {
            minSdkVersion(MIN_SDK_VERSION)
            targetSdkVersion(TARGET_SDK_VERSION)
            versionCode = 1
            versionName = "1.0"
            testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
            manifestPlaceholders["appAuthRedirectScheme"] =
                "io.phoenix.businessmessenger"
        }

        buildFeatures.viewBinding = true
        compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
        compileOptions.targetCompatibility = JavaVersion.VERSION_1_8

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
        testOptions.animationsDisabled = true
    }
}
dependencies {
    // Module
    implementation(project(DESIGN_SYSTEM))
    implementation(project(Modules.DATA))
    Modules.Common.run {
        implementation(project(USECAES))
        implementation(project(SDKEXTENTIONS))
        implementation(project(DATASOURCE))
        implementation(project(MAPPER))
        implementation(project(THREAD))
        implementation(project(TEST_SHARE))
        implementation(project(NETWORKING))
        implementation(project(DI))

    }
    Libs.Glide.run {
        implementation(core)
        kapt(compiler)
        implementation(okHttp)
    }
    //Coroutine
    testImplementation(Libs.Kotlin.Coroutine.test)
    //Android ->Tools
    Libs.AndroidX.run {
        implementation(extensionsCore)
        implementation(constraintLayout)
        implementation(swiperefreshlayout)
        implementation(paging)
    }
    //Android->Fragment
    Libs.AndroidX.Fragment.run {
        implementation(fragmentKtx)
        implementation(fragmentKtx)
        implementation(fragment)
        debugImplementation(test) {
            exclude("androidx.test", "monitor")
        }
    }

    // Android -> Navigation
    Libs.AndroidX.Navigation.run {
        implementation(core)
        implementation(uiKtx)
        implementation(ui)
        implementation(fragment)
        debugImplementation(test)
    }

    //Android->LifeCycle
    Libs.AndroidX.LifeCycle.run {
        implementation(commonJava8)
        implementation(lifecycle_extensions)
        implementation(liveData)
        implementation(runtime)
        implementation(viewModel)
    }

    //Tools
    implementation(Libs.material)
    // Scale
    Libs.Scale.run {
        implementation(sdp)
        implementation(ssp)
    }
    //Kotlin
    implementation(Libs.Kotlin.kotlin_stdlib)
    //Network
    Libs.Network.OkHttp.run {
        implementation(core)
        implementation(logger)
    }
    Libs.Network.Retrofit.run {
        implementation(core)
        implementation(gsonConverter)
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
    //Auth
    implementation(Tools.APP_AUTH)
    //Test
    Test.run {
        androidTestImplementation(barista) { exclude("org.jetbrains.kotlin") }
        androidTestImplementation(core)
        implementation(junit)
        debugImplementation(runner)
        debugImplementation(rules)
        testImplementation(Mockk.mockk)
        androidTestImplementation(Mockk.androidMockk)
        debugImplementation(robolectricEnv)
    }
    Test.Espresso.run {
        debugImplementation(core)
    }
    implementation(Libs.AndroidX.Arch.test)


}

