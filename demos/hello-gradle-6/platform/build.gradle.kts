plugins {
    `java-platform`
    `maven-publish`
}

dependencies {
    constraints {
        api("com.google.guava:guava:24.1.1-jre!!")
        api("com.google.inject:guice:4.2.2")
    }
}

publishing {
    repositories {
        maven { setUrl(rootProject.file("repo")) }
    }
    publications.create<MavenPublication>("maven") {
        from(components["javaPlatform"])
    }
}