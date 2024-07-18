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
    languageContributions.add(LanguageContributionIdentifier(LanguageIdentifier("org.metaborg.devenv", "org.metaborg.meta.lang.template", LanguageVersion.parse("$version")), "TemplateLang"))

    // We add the dependency manually and don't change the repositories
    // Eventually, this functionality should be removed from spoofax.gradle
    addSpoofaxCoreDependency.set(false)
    addSpoofaxRepository.set(false)
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

    compileOnly(libs.spoofax2.core)
}

