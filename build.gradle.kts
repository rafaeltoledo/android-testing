buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0-beta01")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }

    configurations.all {
        resolutionStrategy.eachDependency {
            if (requested.group == "org.jacoco") {
                useVersion("0.8.2")
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
