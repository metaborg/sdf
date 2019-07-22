plugins {
  id("org.metaborg.gradle.config.java-library")
  id("org.metaborg.gradle.config.junit-testing")
}

dependencies {
  api(platform("org.metaborg:parent:$version"))

  api(project(":org.metaborg.parsetable"))

  api("org.metaborg:org.spoofax.terms:$version")
  api("org.metaborg:org.metaborg.util:$version")
  api("org.metaborg:strategoxt-min-jar:$version")

  api("com.google.inject:guice")

  compileOnly("com.google.code.findbugs:jsr305")

  testCompileOnly("junit:junit")
  testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.1.0")
}

// Copy test resources into classes directory, to make them accessible as classloader resources at runtime.
val copyTestResourcesTask = tasks.create<Copy>("copyTestResources") {
  from("$projectDir/src/test/resources")
  into("$buildDir/classes/java/test")
}
tasks.getByName("processTestResources").dependsOn(copyTestResourcesTask)
