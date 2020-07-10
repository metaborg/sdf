rootProject.name = "sdf.root"

pluginManagement {
  repositories {
    maven("https://artifacts.metaborg.org/content/groups/public/")
  }
}

if(org.gradle.util.VersionNumber.parse(gradle.gradleVersion).major < 6) {
  enableFeaturePreview("GRADLE_METADATA")
}

fun includeProject(id: String, path: String = "org.metaborg.$id") {
  include(id)
  project(":$id").projectDir = file(path)
}

include("org.metaborg.parsetable")
includeProject("sdf2table")
include("org.metaborg.meta.lang.template")
