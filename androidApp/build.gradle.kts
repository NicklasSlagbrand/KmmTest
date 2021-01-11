plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}

dependencies {

    val koinVersion = "2.1.6"
    val lifecycleVersion = "2.2.0"
    val coroutinesVersion = "1.3.9"



    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("org.koin:koin-android-viewmodel:$koinVersion")
    implementation("org.koin:koin-android:$koinVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation ("androidx.startup:startup-runtime:1.0.0")

    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("com.jakewharton.timber:timber:4.7.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    implementation ("dev.bluefalcon:library-android:0.0.3")

    testImplementation("junit:junit:4.13.1")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
    testImplementation("org.koin:koin-test:$koinVersion")
    testImplementation("io.mockk:mockk:1.10.2")
    testImplementation("org.amshove.kluent:kluent-android:1.60")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.nicklasslagbrand.kmmtest.androidApp"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {viewBinding = true}

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}