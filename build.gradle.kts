buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.2.1")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }

//    configurations.all {
//        resolutionStrategy {
//            eachDependency { details ->
//                if (details.requested.group == 'org.jacoco') {
//                    details.useVersion '0.8.2'
//                }
//            }
//        }
//    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
