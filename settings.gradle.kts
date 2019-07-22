rootProject.name = "sdf"

pluginManagement {
  repositories {
    // Get plugins from artifacts.metaborg.org, first.
    maven("https://artifacts.metaborg.org/content/repositories/releases/")
    maven("https://artifacts.metaborg.org/content/repositories/snapshots/")
    // Required by several Gradle plugins (Maven central).
    maven("https://artifacts.metaborg.org/content/repositories/central/") // Maven central mirror.
    mavenCentral() // Maven central as backup.
    // Get plugins from Gradle plugin portal.
    gradlePluginPortal()
  }
}

fun includeProject(id: String, path: String = "org.metaborg.$id") {
  include(id)
  project(":$id").projectDir = file(path)
}

includeProject("org.metaborg.parsetable")
includeProject("sdf2table")
