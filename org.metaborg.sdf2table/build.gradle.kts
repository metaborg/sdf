plugins {
    `java-library`
    `maven-publish`
    id("org.metaborg.convention.java")
    id("org.metaborg.convention.maven-publish")
    `java-test-fixtures`
}

dependencies {
    api(platform(libs.metaborg.platform)) { version { require("latest.integration") } }

    api(libs.metaborg.util)

    api(project(":org.metaborg.parsetable"))
    implementation(libs.jakarta.annotation)
    testImplementation(testFixtures(project(":org.metaborg.parsetable")))
    testImplementation(libs.junit)
    testCompileOnly(libs.junit4)
    testRuntimeOnly(libs.junit.vintage)
}

// Copy test resources into classes directory, to make them accessible as classloader resources at runtime.
val copyTestResourcesTask = tasks.create<Copy>("copyTestResources") {
    from("$projectDir/src/test/resources")
    into("$buildDir/classes/java/test")
}
tasks.getByName("processTestResources").dependsOn(copyTestResourcesTask)
