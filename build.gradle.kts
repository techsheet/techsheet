plugins {
  alias(libs.plugins.kotlinMultiplatform) apply false
}

allprojects {
  group = "org.techsheet"
  version = providers.fileContents(rootProject.layout.projectDirectory.file("version.txt"))
    .asText
    .get()
    .trim()

  tasks.withType<Test>().configureEach {
    outputs.upToDateWhen { false }
    testLogging {
      events("passed", "skipped", "failed")
      showExceptions = true
      showCauses = true
      showStackTraces = false
      exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
  }
}
