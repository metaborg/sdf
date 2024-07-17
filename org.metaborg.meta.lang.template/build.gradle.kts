plugins {
    `java-library`
    `maven-publish`
    id("org.metaborg.convention.java")
    id("org.metaborg.convention.maven-publish")
    id("org.metaborg.devenv.spoofax.gradle.langspec")
}

// Replace language dependencies with overridden/local ones.
fun compositeBuild(name: String) = "$group:$name:$version"
val spoofax2BaselineVersion: String by ext
val spoofax2Version: String by ext
spoofaxLanguageSpecification {
    addSourceDependenciesFromMetaborgYaml.set(false)
    addCompileDependenciesFromMetaborgYaml.set(false)
}
dependencies {
    compileLanguage("org.metaborg:org.metaborg.meta.lang.template:$spoofax2BaselineVersion")
    compileLanguage("org.metaborg:org.metaborg.meta.lang.nabl:$spoofax2BaselineVersion")
    compileLanguage("org.metaborg:org.metaborg.meta.lang.esv:$spoofax2BaselineVersion")
    compileLanguage("org.metaborg:org.metaborg.meta.lang.ts:$spoofax2BaselineVersion")
    compileLanguage(compositeBuild("statix.lang"))

    sourceLanguage("org.metaborg:org.metaborg.meta.lib.analysis:$spoofax2Version")
    sourceLanguage(compositeBuild("meta.lib.spoofax"))
    sourceLanguage(compositeBuild("statix.runtime"))
}

metaborg { // Do not create Java publication; this project is already published as a Spoofax 2 language.
    javaCreatePublication = false
    javaCreateSourcesJar = false
    javaCreateJavadocJar = false
}
