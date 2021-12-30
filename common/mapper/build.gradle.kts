import dependencies.Libs

plugins {
    GradlePluginId.apply {
        id(JAVA_LIBRARY)
        id(KOTLIN)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(Libs.Kotlin.kotlin_stdlib)
}