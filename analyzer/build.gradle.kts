@file:OptIn(KotlinNativeCacheApi::class, ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.DisableCacheInKotlinVersion
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeCacheApi

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.kotlinSerialization)
}

base {
  archivesName.set("techsheet-analyzer")
}

kotlin {
  compilerOptions {
    optIn.add("kotlin.uuid.ExperimentalUuidApi")
    optIn.add("kotlinx.serialization.ExperimentalSerializationApi")
  }

  jvm {
    mainRun {
      mainClass.set("org.techsheet.analyzer.MainKt")
    }
  }

  linuxX64 {
    binaries {
      executable {
        baseName = "techsheet-analyzer"
        entryPoint = "org.techsheet.analyzer.main"
      }
      all {
        disableNativeCache(
          version = DisableCacheInKotlinVersion.`2_3_20`,
          reason = "clikt + clikt-mordant export duplicate selfAndAncestors symbol"
        )
      }
    }
  }

  mingwX64 {
    binaries {
      executable {
        baseName = "techsheet-analyzer"
        entryPoint = "org.techsheet.analyzer.main"
      }
      all {
        disableNativeCache(
          version = DisableCacheInKotlinVersion.`2_3_20`,
          reason = "clikt + clikt-mordant export duplicate selfAndAncestors symbol"
        )
      }
    }
  }

  macosArm64 {
    binaries {
      executable {
        baseName = "techsheet-analyzer"
        entryPoint = "org.techsheet.analyzer.main"
      }
      all {
        disableNativeCache(
          version = DisableCacheInKotlinVersion.`2_3_20`,
          reason = "clikt + clikt-mordant export duplicate selfAndAncestors symbol"
        )
      }
    }
  }

  sourceSets {
    commonMain {
      kotlin.srcDir(layout.buildDirectory.dir("generated/version"))
    }
    commonMain.dependencies {
      implementation(projects.core)
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
  val output = layout.buildDirectory.file("generated/version/org/techsheet/analyzer/Version.kt")
  val ver = project.version.toString()
  inputs.property("version", ver)
  outputs.file(output)
  doLast {
    output.get().asFile.apply {
      parentFile.mkdirs()
      writeText("package org.techsheet.analyzer\n\nconst val VERSION = \"$ver\"\n")
    }
  }
}

tasks.configureEach {
  if (name.startsWith("compileKotlin") || name.startsWith("compileCommon")) dependsOn(generateVersion)
}

tasks.named<Jar>("jvmJar") {
  archiveFileName.set("techsheet-analyzer-jvm.jar")
}

tasks.named<Test>("jvmTest") {
  useJUnitPlatform()
}