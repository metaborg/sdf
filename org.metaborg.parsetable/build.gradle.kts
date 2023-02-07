plugins {
  id("org.metaborg.gradle.config.java-library")
  id("org.metaborg.gradle.config.junit-testing")
  `java-test-fixtures`
}

sourceSets {
  testFixtures {
    java {
      srcDirs("src/test/java")
    }
  }
}

fun compositeBuild(name: String) = "$group:$name:$version"
val spoofax2Version: String by ext
dependencies {
  api(platform("org.metaborg:parent:$spoofax2Version"))

  api(compositeBuild("org.spoofax.terms"))

  compileOnly("com.google.code.findbugs:jsr305")
  implementation("com.google.guava:guava")
  // Required for Guava >= 27.0:
  implementation("com.google.guava:failureaccess")
  testCompileOnly("junit:junit")
  testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
  testFixturesCompileOnly("junit:junit")
}
