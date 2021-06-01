plugins {
  id("org.metaborg.gradle.config.java-library")
  id("org.metaborg.devenv.spoofax.gradle.langspec")
  id("de.set.ecj") // Use ECJ to speed up compilation of Stratego's generated Java files.
  `maven-publish`
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
  compileLanguage(compositeBuild("org.metaborg.meta.lang.esv"))

  sourceLanguage(compositeBuild("meta.lib.spoofax"))
  sourceLanguage(compositeBuild("org.metaborg.meta.lang.template"))
  sourceLanguage("org.metaborg:org.metaborg.meta.lib.analysis:$spoofax2Version")
  sourceLanguage(compositeBuild("org.metaborg.meta.nabl2.shared"))
  sourceLanguage(compositeBuild("org.metaborg.meta.nabl2.runtime"))
  sourceLanguage(compositeBuild("statix.lang"))
  sourceLanguage(compositeBuild("statix.runtime"))
}

ecj {
  toolVersion = "3.21.0"
}
tasks.withType<JavaCompile> { // ECJ does not support headerOutputDirectory (-h argument).
  options.headerOutputDirectory.convention(provider { null })
}
