plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.github.jruby-gradle:jruby-gradle-plugin:1.4.0")
    implementation("org.asciidoctor:asciidoctor-gradle-plugin:1.5.9.2")
    implementation("org.ysb33r.gradle:vfs-gradle-plugin:1.0")
    implementation("commons-httpclient:commons-httpclient:3.1")
    implementation("org.ajoberstar:gradle-git:1.1.0")
    implementation("me.champeau.deck2pdf:deck2pdf:0.3.0")
    compileOnly("org.asciidoctor:asciidoctorj:1.5.6")

    components.all(RemoveGroovyRule::class.java)

    constraints {
        implementation("com.jcraft:jsch") {
            version {
                strictly("0.1.54")
            }
        }
    }
}

gradlePlugin {
    plugins {
        register("presentation") {
            id = "org.gradle.presentation.asciidoctor"
            implementationClass = "org.gradle.presentation.plugin.AsciidoctorPresentationPlugin"
        }
    }
}

class RemoveGroovyRule: ComponentMetadataRule {

    override
    fun execute(context: ComponentMetadataContext) = context.details.allVariants {
        withDependencies {
            removeAll {
                it.group == "org.codehaus.groovy"
            }
        }
    }

}