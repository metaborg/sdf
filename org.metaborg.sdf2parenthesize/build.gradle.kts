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

    implementation(project(":org.metaborg.sdf2table"))
    api(project(":org.metaborg.parsetable"))
    implementation(libs.spoofax2.strategoxt.strj)
    implementation(libs.spoofax2.metaborg.util)

    // Annotations & Annotation Processing
    implementation(libs.jakarta.annotation)

    // !! Update dependencies in pom.xml as well
}
