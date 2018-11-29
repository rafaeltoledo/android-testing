plugins {
    id("com.android.application")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "net.rafaeltoledo.testing"
        minSdkVersion(19)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    sourceSets {
        val testDir = listOf("src/test/java")
        sourceSets.getByName("test").java.setSrcDirs(testDir)
        sourceSets.getByName("androidTest").java.setSrcDirs(testDir)
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
        }
    }

    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        animationsDisabled = true
        unitTests.isIncludeAndroidResources = true
    }
}

fun bothTestImplementation(dependency: String) {
    project.dependencies.add("testImplementation", dependency)
    project.dependencies.add("androidTestImplementation", dependency)
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.0.2")

    implementation("androidx.constraintlayout:constraintlayout:2.0.0-alpha2")
    implementation("com.google.android.material:material:1.1.0-alpha01")

    bothTestImplementation("androidx.test:core-ktx:1.1.0-alpha01")
    bothTestImplementation("androidx.test:runner:1.1.1-alpha01")
    bothTestImplementation("androidx.test:rules:1.1.1-alpha01")
    bothTestImplementation("androidx.test.espresso:espresso-core:3.1.1-alpha01")
    bothTestImplementation("androidx.test.ext:junit-ktx:1.1.0-alpha01")

    testImplementation("org.robolectric:robolectric:4.0.2")

    androidTestUtil("androidx.test:orchestrator:1.1.1-alpha01")
}
