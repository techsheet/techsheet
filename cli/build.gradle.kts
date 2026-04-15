plugins {
  alias(libs.plugins.kotlinMultiplatform)
}

base {
  archivesName.set("techsheet-cli")
}

kotlin {
  jvm {
    mainRun {
      mainClass.set("org.techsheet.cli.MainKt")
    }
  }

  linuxX64 {
    binaries {
      executable {
        baseName = "techsheet-cli"
        entryPoint = "org.techsheet.cli.main"
      }
    }
  }

  mingwX64 {
    binaries {
      executable {
        baseName = "techsheet-cli"
        entryPoint = "org.techsheet.cli.main"
      }
    }
  }

  sourceSets {
    commonMain.dependencies {
      implementation(libs.clikt)
      implementation(libs.kermit)
      implementation(libs.okio)
    }
    commonTest.dependencies {
      implementation(libs.kotlin.test)
    }
  }
}
