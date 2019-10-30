plugins {
    `java-library`
}

val loud: SourceSet by sourceSets.creating
java {
    registerFeature("loud") {
        usingSourceSet(loud)
    }
}

dependencies {
    api(platform(project(":platform")))

    api(project(":data"))

    implementation("com.google.guava:guava")

    "loudApi"(project(":data"))
    "loudImplementation"("org.apache.commons:commons-lang3:3.7")

    testImplementation(testFixtures(project(":data")))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0-M1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.withType<Test> {
    useJUnitPlatform()
}