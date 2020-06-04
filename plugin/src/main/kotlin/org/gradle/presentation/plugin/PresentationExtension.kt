package org.gradle.presentation.plugin

import org.asciidoctor.gradle.AsciidoctorTask
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.withType

open class PresentationExtension(val project: Project) {

    val revealjsVersion = project.convention("3.5.0")
    val asciidoctorBackendVersion = project.convention("2.0.0")
    val asciidoctorJVersion = project.convention("1.5.6")
    val githubUserName = project.property<String>()
    val githubRepoName = project.convention(project.name)
    val width = project.convention(1080)
    val heigth = project.convention(700)
    val theme = project.convention("gradle")
    val highlighter = project.convention("highlightjs")
    val asciidoctorDiagramVersion = project.convention("1.5.11")

    fun useAsciidoctorDiagram(version: Provider<String> = asciidoctorDiagramVersion) = project.run {
        dependencies.add("asciidoctor", version.map { "org.asciidoctor:asciidoctorj-diagram:$it" })
        tasks.withType<AsciidoctorTask>().configureEach {
            requires("asciidoctor-diagram")
        }
    }

    fun useAsciidoctorDiagram(version: String) {
        useAsciidoctorDiagram(project.provider { version })
    }
}