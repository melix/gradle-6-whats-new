plugins {
    `java-library`
    `maven-publish`
}

val loud: SourceSet by sourceSets.creating
java {
    registerFeature("loud") {
        usingSourceSet(loud)
    }
}

dependencies {
    implementation(platform(project(":platform")))
    api(project(":data"))
    implementation("com.google.inject:guice:4.2.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0-M1")
    testRuntimeOnly("org.junit.jupiter:jupiter-engine")

    testImplementation(testFixtures(project(":data")))

    "loudApi"(project(":data"))
    "loudImplementation"("org.apache.commons:commons-lang3:3.7")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

publishing {
    repositories {
        maven { setUrl(rootProject.file("repo")) }
    }
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}