plugins {
    `java-library`
    `maven-publish`
    id("org.metaborg.convention.java")
    id("org.metaborg.convention.maven-publish")
    id("org.metaborg.convention.junit")
    `java-test-fixtures`
}

sourceSets {
    testFixtures {
        java {
            srcDirs("src/test/java")
        }
    }
}

dependencies {
    api(platform(libs.metaborg.platform)) { version { require("latest.integration") } }

    api(libs.spoofax.terms)
    implementation(libs.metaborg.util)
    implementation(libs.capsule)
    api(libs.jsglr.shared)

    implementation(libs.jakarta.annotation)
    testCompileOnly(libs.junit4)
    testRuntimeOnly(libs.junit.vintage)
    testFixturesCompileOnly(libs.junit4)
}
