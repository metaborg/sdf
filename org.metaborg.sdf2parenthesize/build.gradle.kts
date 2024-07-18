plugins {
    `java-library`
    `maven-publish`
    id("org.metaborg.convention.java")
    id("org.metaborg.convention.maven-publish")
    `java-test-fixtures`
}

fun compositeBuild(name: String) = "$group:$name:$version"
val spoofax2Version: String by ext
dependencies {
    api(platform(libs.metaborg.platform)) { version { require("latest.integration") } }

    implementation(project(":sdf2table"))
    api(project(":org.metaborg.parsetable"))
    implementation(compositeBuild("org.strategoxt.strj"))
    implementation(compositeBuild("org.metaborg.util"))

    implementation("jakarta.annotation:jakarta.annotation-api")
}
