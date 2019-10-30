import org.gradle.api.artifacts.CacheableRule
import org.gradle.api.artifacts.ComponentMetadataContext
import org.gradle.api.artifacts.ComponentMetadataRule
import org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE

@CacheableRule
class GuavaRule : ComponentMetadataRule {
    override fun execute(ctx: ComponentMetadataContext) {
        val variantVersion = ctx.details.id.version
        val version = variantVersion.substring(0, variantVersion.indexOf("-"))

        val artifactName = variantVersion.substring(variantVersion.indexOf("-") + 1)
        val otherArtifactName = if (artifactName == "android") "jre" else "android"
        val jdkVersion = if (artifactName == "android") 6 else 8
        val otherJdkVersion = if (artifactName == "android") 8 else 6

        ctx.details.allVariants {
            attributes {
                if (!contains(TARGET_JVM_VERSION_ATTRIBUTE)) {
                    attribute(TARGET_JVM_VERSION_ATTRIBUTE, jdkVersion)
                }
            }
        }

        listOf("compile", "runtime").forEach { base ->
            ctx.details.addVariant("jdk${otherJdkVersion}${base.capitalize()}", base) {
                attributes {
                    attribute(TARGET_JVM_VERSION_ATTRIBUTE, otherJdkVersion)
                }
                withFiles {
                    removeAllFiles()
                    addFile("guava-$version-$otherArtifactName.jar",
                            "../$version-$otherArtifactName/guava-$version-$otherArtifactName.jar")
                }
            }
        }
    }
}