buildscript {
    val kotlin_version by extra("1.5.0")
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(GradlePlugins.ANDROID_GRADLE)
        classpath(GradlePlugins.KOTLIN_GRADLE)
        classpath(GradlePlugins.SONAR)
        classpath(GradlePlugins.SAFE_ARGS)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}


allprojects {
    configurations.all {
        resolutionStrategy.force("org.objenesis:objenesis:2.6")
    }
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven("../sdk724-repo")
        maven("https://jitpack.io")
        maven("https://kotlin.bintray.com/kotlinx")
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}