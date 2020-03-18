plugins {
  id("org.metaborg.spoofax.gradle.langspec")
  id("de.set.ecj") // Use ECJ to speed up compilation of Stratego's generated Java files.
  `maven-publish`
}

spoofax {
  createPublication = true
}

ecj {
  toolVersion = "3.20.0"
}

// HACK: Temporarily set group to 'org.metaborgg' to prevent substitution of baseline version of SDF3 to this project.
// I could not find another way to disable this substitution.
group = "org.metaborgg"
// Set group back to 'org.metaborg' before build is executed.
val fixGroupTask = tasks.register("fixGroup") {
  group = "org.metaborg"
}
tasks.named("build") {
  dependsOn(fixGroupTask)
}
