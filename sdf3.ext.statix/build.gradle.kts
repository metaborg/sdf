import org.metaborg.core.language.*

plugins {
    id("org.metaborg.gradle.config.java-library")
    id("org.metaborg.devenv.spoofax.gradle.langspec")
    `maven-publish`
}

// Replace language dependencies with overridden/local ones.
fun compositeBuild(name: String) = "$group:$name:$version"
val spoofax2BaselineVersion: String by ext
val spoofax2Version: String by ext
spoofaxLanguageSpecification {
    addSourceDependenciesFromMetaborgYaml.set(false)
    addCompileDependenciesFromMetaborgYaml.set(false)
    addLanguageContributionsFromMetaborgYaml.set(false)
    languageContributions.add(LanguageContributionIdentifier(LanguageIdentifier("$group", "org.metaborg.meta.lang.template", LanguageVersion.parse("$version")), "TemplateLang"))
}
dependencies {
    compileLanguage(compositeBuild("org.metaborg.meta.lang.esv"))

    sourceLanguage(compositeBuild("meta.lib.spoofax"))
    sourceLanguage(compositeBuild("org.metaborg.meta.lang.template"))
    sourceLanguage("org.metaborg:org.metaborg.meta.lib.analysis:$spoofax2Version")
    sourceLanguage(compositeBuild("org.metaborg.meta.nabl2.shared"))
    sourceLanguage(compositeBuild("org.metaborg.meta.nabl2.runtime"))
    sourceLanguage(compositeBuild("statix.lang"))
    sourceLanguage(compositeBuild("statix.runtime"))
    sourceLanguage(compositeBuild("stratego.lang"))
}

metaborg { // Do not create Java publication; this project is already published as a Spoofax 2 language.
    javaCreatePublication = false
    javaCreateSourcesJar = false
    javaCreateJavadocJar = false
}
