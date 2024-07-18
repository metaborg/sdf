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

    // We add the dependency manually and don't change the repositories
    // Eventually, this functionality should be removed from spoofax.gradle
    addSpoofaxCoreDependency.set(false)
    addSpoofaxRepository.set(false)
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

    compileOnly(libs.spoofax2.core)
}
