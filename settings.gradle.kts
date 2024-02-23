rootProject.name = "sdf-project"

// This is needed to let Gradle find the dependencies of the spoofax2-gradle plugin
pluginManagement {
  repositories {
    maven("https://artifacts.metaborg.org/content/groups/public/")
  }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from("dev.spoofax:spoofax3-catalog:0.0.0-SNAPSHOT")
        }
    }
}

include("org.metaborg.meta.lang.template")
//include("org.metaborg.parsetable")
//include("org.metaborg.sdf2parenthesize")
//include("org.metaborg.sdf2table")
//include("sdf3.ext.statix")
