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
    }
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.Coroutine.core)
    implementation(Libs.Kotlin.Coroutine.android)
    implementation(Libs.timber)
    implementation(project(Modules.DATA))

}
