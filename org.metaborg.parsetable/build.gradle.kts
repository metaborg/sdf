plugins {
  id("org.metaborg.gradle.config.java-library")
  id("org.metaborg.gradle.config.junit-testing")
}

dependencies {
  // api(platform("org.metaborg:parent:$version")) // Can't use: causes dependency cycle because parent mentions pie.

  api("org.metaborg:org.spoofax.terms:$version")
  compileOnly("com.google.code.findbugs:jsr305:3.0.2")
  api("com.google.guava:guava:26.0-jre")
  testCompileOnly("junit:junit:4.12")
  testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.1.0")
}
