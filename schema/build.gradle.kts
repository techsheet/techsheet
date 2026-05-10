plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.kotlinSerialization)
}

kotlin {
  compilerOptions {
    optIn.add("kotlin.uuid.ExperimentalUuidApi")
    optIn.add("kotlinx.serialization.ExperimentalSerializationApi")
  }

  jvm()
  linuxX64()
  mingwX64()
  macosArm64()

  sourceSets {
    commonMain.dependencies {
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.konform)
    }
    commonTest.dependencies {
      implementation(libs.kotlin.test)
    }
  }
}
