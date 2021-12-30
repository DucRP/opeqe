package dependencies

object Libs {
    const val material = "com.google.android.material:material:1.4.0-alpha02"// last update 02/04
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val multidex = "com.android.support:multidex:1.0.3"


    object AndroidX {
        private const val paging_version = "3.1.0-alpha01" // last update 02/29
        const val paging = "androidx.paging:paging-runtime-ktx:$paging_version"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:2.1.0-beta01"// last update 02/04
        const val swiperefreshlayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"// last update 02/04

        const val extensionsCore = "androidx.core:core-ktx:1.6.0-rc01"// last update 02/04

        object Fragment { // last update 02/04
            private const val fragment_version = "1.3.3"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragment_version"
            const val fragment = "androidx.fragment:fragment:$fragment_version"
            const val test = "androidx.fragment:fragment-testing:$fragment_version"
        }


        object LifeCycle {
            private const val version = "2.4.0-alpha01"
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:2.0.0-alpha1"
        }

        object Arch {
            private const val version = "2.1.0"// last update 02/16
            const val core = "androidx.arch.core:core-common:$version"
            const val runtime = "androidx.arch.core:core-runtime:$version"
            const val test = "androidx.arch.core:core-testing:$version"
        }

        object Navigation {
            // last update 02/04
            const val version = "2.3.5"
            const val core = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
            const val fragment = "androidx.navigation:navigation-fragment:$version"
            const val test = "androidx.navigation:navigation-testing:$version"
        }

        object DataStore {
            private const val version = "1.0.0-beta02"// last update 03/04
            const val preferences = "androidx.datastore:datastore-preferences:$version"
            const val core = "androidx.datastore:datastore-preferences-core:$version"
        }

        object Room {
            private const val version = "2.4.0-alpha01"// last update 02/04
            const val compiler = "androidx.room:room-compiler:$version"
            const val core = "androidx.room:room-ktx:$version"
            const val runtime = "androidx.room:room-runtime:$version"
        }
    }


    object DependencyInjection {
        // last update 02/04
        object Dagger {
            private const val version = "2.35"
            const val runtime = "com.google.dagger:dagger:$version"
            const val android = "com.google.dagger:dagger-android:$version"
            const val android_support = "com.google.dagger:dagger-android-support:$version"
            const val compiler = "com.google.dagger:dagger-compiler:$version"
            const val android_support_compiler =
                "com.google.dagger:dagger-android-processor:$version"

            object Assisted {
                private const val version = "0.8.1"
                const val annotations =
                    "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
                const val processor =
                    "com.squareup.inject:assisted-inject-processor-dagger2:$version"
            }
        }
    }

    object Stetho {
        private const val version = "1.5.1"
        const val okHttp = "com.facebook.stetho:stetho-okhttp3:${version}"
        const val core = "com.facebook.stetho:stetho:${version}"
    }

    object Glide {
        private const val version = "4.12.0"// last update 02/04
        const val core = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
        const val okHttp = "com.github.bumptech.glide:okhttp3-integration:$version"
    }

    object Kotlin {
        const val version = "1.4.32"
        const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"

        object Coroutine {
            private const val version = "1.5.0"// last update 03/04
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Network {
        object OkHttp {
            private const val version = "5.0.0-alpha.2"// last update 02/04
            const val core = "com.squareup.okhttp3:okhttp:$version"
            const val logger = "com.squareup.okhttp3:logging-interceptor:$version"
            const val test = "com.squareup.okhttp3:mockwebserver:$version"
        }

        object Retrofit {
            private const val version = "2.9.0"
            const val core = "com.squareup.retrofit2:retrofit:$version"
            const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
        }
    }

    object Scale {
        private const val version = "1.0.6"
        const val ssp = "com.intuit.ssp:ssp-android:$version"
        const val sdp = "com.intuit.sdp:sdp-android:$version"
    }

}

object Gradle {
    const val androidGradleVersion = "4.1.1"
}

object Tools {
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.2"
    const val APP_AUTH = "net.openid:appauth:0.7.1"

}

object Test {
    private const val coreVersion = "1.4.0-alpha06"
    private const val robolectricVersion = "4.3.1"
    private const val junitVersion = "4.12"
    private const val jsonVersion = "20180813"
    private const val runnerVersion = "1.2.0"

    const val barista = "com.schibsted.spain:barista:3.6.0"
    const val json = "org.json:json:$jsonVersion"
    const val robolectricEnv = "androidx.test:core:$coreVersion"
    const val robolectric = "org.robolectric:robolectric:$robolectricVersion"

    const val core = "androidx.test:core-ktx:$runnerVersion"
    const val junit = "androidx.test.ext:junit-ktx:1.1.1"
    const val runner = "androidx.test:runner:$runnerVersion"
    const val rules = "androidx.test:rules:$runnerVersion"
    const val truth = "androidx.test.ext:truth:$runnerVersion"

    object Espresso {
        private const val version = "3.4.0-alpha06"
        const val core = "androidx.test.espresso:espresso-core:$version"// last update 02/16
        const val contrib = "androidx.test.espresso:espresso-contrib:$version"
        const val intents = "androidx.test.espresso:espresso-intents:$version"
        const val accessibility = "androidx.test.espresso:espresso-accessibility:$version"
        const val web = "androidx.test.espresso:espresso-web:$version"
        const val concurrent = "androidx.test.espresso.idling:idling-concurrent:$version"
    }

    object Mockk {
        private const val version = "1.10.5"
        const val mockk = "io.mockk:mockk:$version"
        const val androidMockk = "io.mockk:mockk-android:$version"
    }

    object Mockito {
        private const val mockitoKotlinVersion = "2.2.0"
        private const val mockitoCoreVersion = "3.7.0"
        const val mockito = "org.mockito:mockito-core:$mockitoCoreVersion"
        const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoKotlinVersion"
    }
}
