plugins {
  id("org.metaborg.gradle.config.java-library")
  id("org.metaborg.gradle.config.junit-testing")
  `java-test-fixtures`
}

dependencies {
  // api(platform("org.metaborg:parent:$version")) // Can't use: causes dependency cycle because parent mentions pie.

  api("org.metaborg:org.metaborg.util:$version")
  api(project(":org.metaborg.parsetable"))
  api("com.google.inject:guice:4.2.0")
  compileOnly("com.google.code.findbugs:jsr305:3.0.2")
  testImplementation(testFixtures(project(":org.metaborg.parsetable")))
  testCompileOnly("junit:junit:4.12")
  testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.1.0")
}

// Copy test resources into classes directory, to make them accessible as classloader resources at runtime.
val copyTestResourcesTask = tasks.create<Copy>("copyTestResources") {
  from("$projectDir/src/test/resources")
  into("$buildDir/classes/java/test")
}
tasks.getByName("processTestResources").dependsOn(copyTestResourcesTask)
