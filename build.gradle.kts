plugins {
    id("org.gradle.presentation.asciidoctor")
}

presentation {
    githubUserName.set("melix")
    githubRepoName.set("gradle-6-whats-new")
}

dependencies {
    asciidoctor("org.asciidoctor:asciidoctorj-diagram:1.5.11")
}

tasks {
    asciidoctor {
        requires("asciidoctor-diagram")
    }
}
