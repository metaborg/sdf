plugins {
    id("org.metaborg.gradle.config.java-library")
    id("org.metaborg.gradle.config.junit-testing")
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
    api(platform("org.metaborg:parent:$spoofax2Version"))

    api(compositeBuild("org.spoofax.terms"))
    implementation(compositeBuild("org.metaborg.util"))
    implementation("io.usethesource:capsule")
    api(compositeBuild("jsglr.shared"))

    implementation("jakarta.annotation:jakarta.annotation-api")
    testCompileOnly("junit:junit")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
    testFixturesCompileOnly("junit:junit")
}
