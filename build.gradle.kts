buildscript {
    dependencies {
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.jetbrainsKotlinJvm) apply false
    alias(libs.plugins.sonarqube)
    alias(libs.plugins.android.library) apply false
}

// SonarQube plugin configuration
sonarqube {
    properties {
        // Required
        property("sonar.host.url", "https://sonarqube.app.mrmisti.com")
        property("sonar.token", "sqp_440f90bc3f55fe5198617668b306a82f216e5d69")
        property("sonar.projectKey", "copilotdeck2")
        property("sonar.projectName", "CopilotDeck")
        property("sonar.coverage.jacoco.xmlReportPaths", "**/jacoco/**/*Report.xml")
        // Optional
        property("sonar.sources", "src/main/java")
        property("sonar.tests", "src/test/java")
        property("sonar.sourceEncoding", "UTF-8")
        property(
            "sonar.exclusions",
            "**/*Test*/**," +
                    "*.json," +
                    "**/*test*/**," +
                    "**/.gradle/**," +
                    "**/R.class," +
                    "**/R.class," +
                    "**/R\$*.class," +
                    "**/BuildConfig.*," +
                    "**/Manifest*.*," +
                    "**/*_Hilt*.class," +
                    "**/*Test*.*,",
        )
    }
}
