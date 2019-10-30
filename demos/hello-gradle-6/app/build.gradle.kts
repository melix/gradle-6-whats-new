plugins {
    application
}

application {
    mainClassName = "org.gradle.hello6.HelloApp"
}

dependencies {
    implementation(platform(project(":platform")))

    implementation(project(":hello-java-service"))
    implementation(project(":hello-java-service")) {
        capabilities { requireCapability("org.gradle.hello6:hello-java-service-loud") }
    }

    implementation("com.google.inject:guice")
}