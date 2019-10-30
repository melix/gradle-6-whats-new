subprojects {
    repositories {
        mavenCentral()
        maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots/") }
    }
}

// Set common group and version for all projects - required for publishing and to address capabilities
subprojects {
    group = "org.gradle.hello6"
    version = "0.1"
}

// Register Guava component metadata rule for all subprojects
subprojects {
    dependencies {
        components {
            withModule<GuavaRule>("com.google.guava:guava")
        }
    }
}

// Set the Java version for all subprojects
subprojects {
    plugins.withType<JavaPlugin> {
        extensions.configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_13
            targetCompatibility = JavaVersion.VERSION_13
        }
    }
}













// Config for demonstration purpose only
subprojects {
    // Fake a slow compiling Groovy class
    tasks.withType<GroovyCompile> {
        groovyOptions.configurationScript = file("config.groovy")
    }
    // Show the actual resolved Guava artifact
    tasks.create("checkGuavaJar") {
        doLast {
            configurations["compileClasspath"].incoming.files.filter { it.name.contains("guava") }.forEach { println(it.name) }
        }
    }
}