plugins {
    `java-library`
    `java-test-fixtures`
}

// FIXME: Move this to a common spot
repositories {
    mavenCentral()
    maven("https://nexus.usethesource.io/content/repositories/releases/")
    maven("https://artifacts.metaborg.org/content/groups/public/")
}

dependencies {
    // FIXME: Move these platform definitions to a common spot
    api(platform(libs.spoofax3.bom))
    testImplementation(platform(libs.spoofax3.bom))
    annotationProcessor(platform(libs.spoofax3.bom))
    testAnnotationProcessor(platform(libs.spoofax3.bom))

    // !! Update dependencies in pom.xml as well

    api(libs.spoofax2.terms)
    implementation(libs.spoofax2.jsglr.shared)
    implementation(libs.capsule)
    implementation(libs.spoofax2.metaborg.util)

    // Annotations & Annotation Processing
    implementation(libs.jakarta.annotation)

    // Testing
    testImplementation(libs.junit4)
    testImplementation(libs.junit)
    testRuntimeOnly(libs.junit.vintage)
    testImplementation(libs.logback)

    testFixturesImplementation(libs.junit4)
    testFixturesImplementation(libs.junit)

    // !! Update dependencies in pom.xml as well
}

sourceSets {
    testFixtures {
        java {
            srcDirs("src/test/java")
        }
    }
}