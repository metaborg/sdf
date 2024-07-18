plugins {
    `java-library`
    `maven-publish`
    id("org.metaborg.convention.java")
    id("org.metaborg.convention.maven-publish")
    id("org.metaborg.devenv.spoofax.gradle.langspec")
}

spoofaxLanguageSpecification {
    addSourceDependenciesFromMetaborgYaml.set(false)
    addCompileDependenciesFromMetaborgYaml.set(false)
}
dependencies {
    compileLanguage(libs.spoofax2.sdf3.lang)    // Bootstrap using Spoofax 2 artifact
    compileLanguage(libs.spoofax2.nabl.lang)    // Bootstrap using Spoofax 2 artifact
    compileLanguage(libs.spoofax2.esv.lang)     // Bootstrap using Spoofax 2 artifact
    compileLanguage(libs.spoofax2.ts.lang)      // Bootstrap using Spoofax 2 artifact
    compileLanguage(libs.statix.lang)

    sourceLanguage(libs.meta.lib.analysis)
    sourceLanguage(libs.spoofax2.meta.lib.spoofax)
    sourceLanguage(libs.statix.runtime)

metaborg { // Do not create Java publication; this project is already published as a Spoofax 2 language.
    javaCreatePublication = false
    javaCreateSourcesJar = false
    javaCreateJavadocJar = false
}
