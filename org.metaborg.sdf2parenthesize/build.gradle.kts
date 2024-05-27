plugins {
    id("org.metaborg.gradle.config.java-library")
    `java-test-fixtures`
}

fun compositeBuild(name: String) = "$group:$name:$version"
val spoofax2Version: String by ext
dependencies {
    api(platform("org.metaborg:parent:$spoofax2Version"))

    implementation(project(":sdf2table"))
    api(project(":org.metaborg.parsetable"))
    implementation(compositeBuild("org.strategoxt.strj"))
    implementation(compositeBuild("org.metaborg.util"))

    implementation("jakarta.annotation:jakarta.annotation-api")
}
