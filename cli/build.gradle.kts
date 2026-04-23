plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.kotlinSerialization)
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

  macosArm64 {
    binaries {
      executable {
        baseName = "techsheet-cli"
        entryPoint = "org.techsheet.cli.main"
      }
    }
  }

  sourceSets {
    commonMain {
      kotlin.srcDir(layout.buildDirectory.dir("generated/version"))
    }
    commonMain.dependencies {
      implementation(libs.clikt)
      implementation(libs.kermit)
      implementation(libs.okio)
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.kotlinx.datetime)
      implementation(libs.kaml)
    }
    commonTest.dependencies {
      implementation(libs.kotlin.test)
      implementation(libs.okio.fakefilesystem)
    }
    jvmTest.dependencies {
      implementation(libs.kotlin.test.junit5)
      implementation(libs.junit.jupiter)
    }
  }
}

val generateVersion by tasks.registering {
  val output = layout.buildDirectory.file("generated/version/org/techsheet/cli/CliVersion.kt")
  val ver = project.version.toString()
  outputs.file(output)
  doLast {
    output.get().asFile.apply {
      parentFile.mkdirs()
      writeText("package org.techsheet.cli\n\nconst val CLI_VERSION = \"$ver\"\n")
    }
  }
}

tasks.configureEach {
  if (name.startsWith("compileKotlin") || name.startsWith("compileCommon")) dependsOn(generateVersion)
}

tasks.named<Jar>("jvmJar") {
  archiveFileName.set("techsheet-cli-jvm.jar")
}

tasks.named<Test>("jvmTest") {
  useJUnitPlatform()
}
