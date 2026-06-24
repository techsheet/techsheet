plugins {
  kotlin("jvm")
  alias(libs.plugins.kotlinSerialization)
}

dependencies {
  implementation(projects.analyzer)
  implementation(libs.kaml)
}

val updateDocs by tasks.registering(JavaExec::class) {
  group = "documentation"
  description = "Sync technology doc pages and README counts from DetectedTechnology enums"
  dependsOn(tasks.compileKotlin)
  mainClass.set("org.techsheet.docs.UpdateTechnologyDocsKt")
  classpath(sourceSets.main.get().output, sourceSets.main.get().runtimeClasspath)
  args(
    project.file("content/technology").absolutePath,
    rootProject.file("README.md").absolutePath,
    project.file("content/_index.md").absolutePath,
  )
}
