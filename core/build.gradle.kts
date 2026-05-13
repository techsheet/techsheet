plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.kotlinSerialization)
}

kotlin {
  compilerOptions {
    optIn.add("kotlinx.serialization.ExperimentalSerializationApi")
  }

  jvm()
  linuxX64()
  mingwX64()
  macosArm64()

  sourceSets {
    commonMain.dependencies {
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.kaml)
      implementation(libs.konform)
      implementation(libs.json.schema.validator)
      implementation(libs.ktor.client.core)
      implementation(libs.ktor.client.cio)
      implementation(libs.okio)
    }
    commonTest.dependencies {
      implementation(libs.kotlin.test)
      implementation(libs.okio.fakefilesystem)
      implementation(libs.ktor.client.mock)
    }
    jvmTest.dependencies {
      implementation(libs.kotlin.test.junit5)
      implementation(libs.junit.jupiter)
    }
  }
}

tasks.named<Test>("jvmTest") {
  useJUnitPlatform()
}
