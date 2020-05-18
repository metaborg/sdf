rootProject.name = "sdf"

pluginManagement {
  repositories {
    maven("https://artifacts.metaborg.org/content/groups/public/")
  }
}

enableFeaturePreview("GRADLE_METADATA")

fun includeProject(id: String, path: String = "org.metaborg.$id") {
  include(id)
  project(":$id").projectDir = file(path)
}

include("org.metaborg.parsetable")
includeProject("sdf2table")
include("org.metaborg.meta.lang.template")
