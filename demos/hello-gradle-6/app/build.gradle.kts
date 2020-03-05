plugins {
    application
}

application {
    mainClassName = "org.gradle.hello6.HelloApp"
}

dependencies {
    implementation(platform(project(":platform")))

    implementation(project(":hello-java-service"))
    implementation("com.google.guava:guava")

    implementation(project(":hello-java-service")) {
        capabilities {
            requireCapability("org.gradle.hello6:hello-java-service-loud")
        }
    }
}