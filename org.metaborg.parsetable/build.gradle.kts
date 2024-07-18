plugins {
    `java-library`
    `maven-publish`
    id("org.metaborg.convention.java")
    id("org.metaborg.convention.maven-publish")
    `java-test-fixtures`
}

sourceSets {
    testFixtures {
        java {
            srcDirs("src/test/java")
        }
    }
}

fun compositeBuild(name: String) = "$group:$name:$version"
val spoofax2Version: String by ext
dependencies {
    api(platform(libs.metaborg.platform)) { version { require("latest.integration") } }

    api(compositeBuild("org.spoofax.terms"))
    implementation(compositeBuild("org.metaborg.util"))
    implementation("io.usethesource:capsule")
    api(compositeBuild("jsglr.shared"))

    implementation("jakarta.annotation:jakarta.annotation-api")
    testCompileOnly("junit:junit")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
    testFixturesCompileOnly("junit:junit")
}
