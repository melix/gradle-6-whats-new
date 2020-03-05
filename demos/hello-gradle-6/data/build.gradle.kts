plugins {
    `java-library`
    `maven-publish`
    `java-test-fixtures`
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    repositories {
        maven { setUrl(rootProject.file("repo")) }
    }
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}