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

dependencies {
  api(platform("org.metaborg:parent:$version"))

  api("org.metaborg:org.spoofax.terms:$version")
  compileOnly("com.google.code.findbugs:jsr305")
  api("com.google.guava:guava")
  testCompileOnly("junit:junit")
  testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
  testFixturesCompileOnly("junit:junit")
}
