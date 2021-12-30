import dependencies.Gradle
import dependencies.Libs

object GradlePluginVersion {
    const val ANDROID_GRADLE = Gradle.androidGradleVersion
    const val KOTLIN = Libs.Kotlin.version
    const val SAFE_ARGS = Libs.AndroidX.Navigation.version
    const val SONAR = "2.7.1"
}

object Repo {
  /*  object Artifactory {
        const val google = "https://repo.phoenix.mahsan.net/artifactory/google"
        const val jcenter = "https://repo.phoenix.mahsan.net/artifactory/jcenter"

    }*/
}

object Modules {
    object Common {
        private const val dir = ":common"
        const val TEST_SHARE = "$dir:test-share"
        const val NETWORKING = "$dir:networking"
        const val MAPPER = "$dir:mapper"
        const val DATASOURCE = "$dir:datasource"
        const val THREAD = "$dir:thread"
        const val SDKEXTENTIONS = "$dir:sdkextentions"
        const val USECAES = "$dir:usecase"
        const val DI = "$dir:di"
    }

    object Feature {
        private const val dir = ":feature"
        const val CRYPTO_CURRENCY_LIST = "$dir:userList"
        const val CRYPTO_CURRENCY_DETAIL = "$dir:userDetail"
    }

    const val CORE = ":core"
    const val DATA = ":data"
    const val DESIGN_SYSTEM = ":designSystem"
}

object GradlePluginId {
    const val PARCELIZE = "kotlin-parcelize"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN = "kotlin"
    const val JAVA_LIBRARY = "java-library"
    const val ANDROID_LIBRARY = "com.android.library"
    const val ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val ANDROID_APPLICATION = "com.android.application"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val SONAR = "org.sonarqube"
    const val NAVIGATION_SAFEARGS_KOTLIN = "androidx.navigation.safeargs.kotlin"
    const val KOTLIN_Hilt = "dagger.hilt.android.plugin"
    const val FABRIC = "io.fabric"
}

object PackagingOptions {
    const val DEPENDENCIES = "META-INF/DEPENDENCI"
    const val LICENSE = "META-INF/LICENSE"
    const val LICENSE_TEXT = "META-INF/LICENSE.txt"
    const val LICENSE_TEXT_2 = "META-INF/license.txt"
    const val NOTICE = "META-INF/NOTICE"
    const val NOTICE_TEXT = "META-INF/NOTICE.txt"
    const val NOTICE_TEXT_2 = "META-INF/notice.txt"
    const val ASL2 = "META-INF/ASL2.0"
    const val AL2 = "META-INF/AL2.0"
    const val KOTLIN = "META-INF/*.kotlin_modul"
    const val LGPL2 = "META-INF/LGPL2.1"
}

object GradlePlugins {

    const val ANDROID_GRADLE =
        "com.android.tools.build:gradle:${GradlePluginVersion.ANDROID_GRADLE}"
    const val KOTLIN_GRADLE =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${GradlePluginVersion.KOTLIN}"
    const val SAFE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${GradlePluginVersion.SAFE_ARGS}"
    const val SONAR =
        "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:${GradlePluginVersion.SONAR}"
}

