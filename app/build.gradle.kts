import dependencies.Libs
import dependencies.Libs.DependencyInjection.Dagger
import dependencies.Tools

plugins {
    GradlePluginId.apply {
        id(ANDROID_APPLICATION)
        id(KOTLIN_ANDROID)
        id(PARCELIZE)
        id(KOTLIN_KAPT)
        id(SONAR)
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
        buildToolsVersion(BUILD_TOOLS_VERSION)

        defaultConfig {
            applicationId = APPLICATION_ID
            minSdkVersion(MIN_SDK_VERSION)
            targetSdkVersion(TARGET_SDK_VERSION)
            versionCode = 1
            versionName = "1.0"
            testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
            manifestPlaceholders["appAuthRedirectScheme"] =
                "io.phoenix.businessmessenger"
            multiDexEnabled = true

        }
        testOptions.animationsDisabled = true
        compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
        compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs =
            freeCompilerArgs.toMutableList().apply { add("-Xopt-in=kotlin.RequiresOptIn") }
    }
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    android.buildFeatures.viewBinding = true
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(Modules.CORE))
    implementation(project(Modules.DESIGN_SYSTEM))
    implementation(project(Modules.DATA))

    implementation(project(Modules.Feature.CRYPTO_CURRENCY_LIST))
    implementation(project(Modules.Feature.CRYPTO_CURRENCY_DETAIL))


    Modules.Common.run {
        implementation(project(MAPPER))
        implementation(project(DATASOURCE))
        implementation(project(USECAES))
        implementation(project(SDKEXTENTIONS))
        implementation(project(THREAD))
        implementation(project(DI))
    }



    implementation(Libs.timber)
    implementation(Libs.AndroidX.Fragment.fragmentKtx)
    implementation(Libs.AndroidX.Fragment.fragment)
    implementation(Tools.leakCanary)
    implementation(Libs.AndroidX.LifeCycle.commonJava8)
    implementation(Libs.AndroidX.LifeCycle.liveData)
    implementation(Libs.AndroidX.LifeCycle.runtime)
    implementation(Libs.AndroidX.LifeCycle.viewModel)
    implementation(Libs.AndroidX.LifeCycle.lifecycle_extensions)
    implementation(Libs.material)
    implementation(Libs.AndroidX.extensionsCore)
    implementation(Libs.Kotlin.kotlin_stdlib)

    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.Navigation.core)
    implementation(Libs.AndroidX.Navigation.uiKtx)
    implementation(Libs.Stetho.okHttp)
    implementation(Libs.Stetho.core)
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    kapt(Libs.AndroidX.Room.compiler)
    implementation(Libs.AndroidX.paging)
    implementation(Libs.Network.OkHttp.core)
    implementation(Libs.Network.OkHttp.logger)
    implementation(Libs.Network.Retrofit.core)
    implementation(Libs.Network.Retrofit.gsonConverter)
    implementation(Libs.AndroidX.Room.core)
    implementation(Tools.APP_AUTH)


    Dagger.run {
        implementation(runtime)
        implementation(android)
        implementation(android_support)
        kapt(compiler)
        kapt(android_support_compiler)
    }
    implementation(Libs.multidex)


}