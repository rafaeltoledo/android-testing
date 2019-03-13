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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
    implementation("androidx.appcompat:appcompat:1.1.0-alpha03")
    implementation("androidx.activity:activity:1.0.0-alpha05")
    implementation("androidx.fragment:fragment:1.1.0-alpha05")

    implementation("androidx.constraintlayout:constraintlayout:2.0.0-alpha3")
    implementation("com.google.android.material:material:1.1.0-alpha04")

    bothTestImplementation("androidx.test:core-ktx:1.1.1-alpha02")
    bothTestImplementation("androidx.test:runner:1.1.2-alpha02")
    bothTestImplementation("androidx.test:rules:1.1.2-alpha02")
    bothTestImplementation("androidx.test.espresso:espresso-core:3.2.0-alpha02")
    bothTestImplementation("androidx.test.ext:junit-ktx:1.1.1-alpha02")
    bothTestImplementation("androidx.fragment:fragment-testing:1.1.0-alpha04")

    testImplementation("org.robolectric:robolectric:4.2")

    androidTestUtil("androidx.test:orchestrator:1.1.2-alpha02")
}
