plugins {
    `java-library`
    `maven-publish`
    id("org.metaborg.convention.java")
    id("org.metaborg.convention.maven-publish")
    `java-test-fixtures`
}

dependencies {
    api(platform(libs.metaborg.platform)) { version { require("latest.integration") } }

    implementation(project(":sdf2table"))
    api(project(":org.metaborg.parsetable"))
    implementation(libs.strategoxt.strj)
    implementation(libs.metaborg.util)

    implementation(libs.jakarta.annotation)
}
