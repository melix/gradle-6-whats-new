plugins {
    id("org.gradle.presentation.asciidoctor")
}

presentation {
    githubUserName.set("melix")
    githubRepoName.set("gradle-6-whats-new")
    useAsciidoctorDiagram()
}
