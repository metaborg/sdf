plugins {
    `java-library`
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

    implementation(libs.spoofax2.metaborg.util)

    api(project(":org.metaborg.parsetable"))

    // Dependency injection
    implementation(libs.guice)

    // Annotations & Annotation Processing
    implementation(libs.jakarta.annotation)

    // Utils
    implementation(libs.commons.io)

    // Testing
    testImplementation(testFixtures(project(":org.metaborg.parsetable")))
    testImplementation(libs.junit4)
    testImplementation(libs.junit)
    testRuntimeOnly(libs.junit.vintage)

    // !! Update dependencies in pom.xml as well
}


// FIXME: If this is necessary, use testFixtures instead
//// Copy test resources into classes directory, to make them accessible as classloader resources at runtime.
//val copyTestResourcesTask = tasks.create<Copy>("copyTestResources") {
//  from("$projectDir/src/test/resources")
//  into("$buildDir/classes/java/test")
//}
//tasks.getByName("processTestResources").dependsOn(copyTestResourcesTask)
