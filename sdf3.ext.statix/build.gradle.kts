import org.metaborg.core.language.*

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
    addLanguageContributionsFromMetaborgYaml.set(false)
    languageContributions.add(LanguageContributionIdentifier(LanguageIdentifier("$group", "org.metaborg.meta.lang.template", LanguageVersion.parse("$version")), "TemplateLang"))
}
dependencies {
    compileLanguage(libs.spoofax2.esv.lang)     // Bootstrap using Spoofax 2 artifact

    sourceLanguage(libs.spoofax2.meta.lib.spoofax)
    sourceLanguage(libs.sdf3.lang)
    sourceLanguage(libs.meta.lib.analysis)
    sourceLanguage(libs.nabl2.shared)
    sourceLanguage(libs.nabl2.runtime)
    sourceLanguage(libs.statix.lang)
    sourceLanguage(libs.statix.runtime)
    sourceLanguage(libs.stratego2.lang)

metaborg { // Do not create Java publication; this project is already published as a Spoofax 2 language.
    javaCreatePublication = false
    javaCreateSourcesJar = false
    javaCreateJavadocJar = false
}
