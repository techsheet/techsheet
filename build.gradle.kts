plugins {
  alias(libs.plugins.kotlinMultiplatform) apply false
}

allprojects {
  group = "org.techsheet"
  version = rootProject.file("version.txt")
    .readText()
    .trim()
}
