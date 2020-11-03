plugins {
  id("org.metaborg.gradle.config.java-library")
  id("org.metaborg.gradle.config.junit-testing")
  `java-test-fixtures`
}

dependencies {
  api(platform("org.metaborg:parent:$version"))

  api("org.metaborg:org.metaborg.util:$version")
  api(project(":org.metaborg.parsetable"))
  api("com.google.inject:guice")
  compileOnly("com.google.code.findbugs:jsr305")
  testImplementation(testFixtures(project(":org.metaborg.parsetable")))
  testCompileOnly("junit:junit")
  testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
}

// Copy test resources into classes directory, to make them accessible as classloader resources at runtime.
val copyTestResourcesTask = tasks.create<Copy>("copyTestResources") {
  from("$projectDir/src/test/resources")
  into("$buildDir/classes/java/test")
}
tasks.getByName("processTestResources").dependsOn(copyTestResourcesTask)
