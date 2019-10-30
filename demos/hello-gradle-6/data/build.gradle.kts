plugins {
    `java-library`
    `java-test-fixtures`
    `maven-publish`
}

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    api(platform(project(":platform")))
}

publishing {
    repositories {
        maven { setUrl(rootProject.file("repo")) }
    }
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}