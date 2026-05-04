plugins {
  alias(libs.plugins.kotlinMultiplatform) apply false
}

allprojects {
  group = "org.techsheet"
  version = providers.fileContents(rootProject.layout.projectDirectory.file("version.txt"))
    .asText
    .get()
    .trim()
}
