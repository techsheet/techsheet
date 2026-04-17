package org.techsheet.cli.domain

data class Framework(
  val type: FrameworkType,
  val version: String?,
)

enum class FrameworkType(val title: String, val category: FrameworkCategory) {

  // Application
  ANGULAR("Angular", FrameworkCategory.APPLICATION),
  REACT("React", FrameworkCategory.APPLICATION),
  VUE("Vue.js", FrameworkCategory.APPLICATION),
  SVELTE("Svelte", FrameworkCategory.APPLICATION),
  NEXT("Next.js", FrameworkCategory.APPLICATION),
  EXPRESS("Express", FrameworkCategory.APPLICATION),
  QT("Qt", FrameworkCategory.APPLICATION),
  ASP_NET_CORE("ASP.NET Core", FrameworkCategory.APPLICATION),
  SPRING_BOOT("Spring Boot", FrameworkCategory.APPLICATION),
  SPRING_MVC("Spring MVC", FrameworkCategory.APPLICATION),
  SPRING_WEBFLUX("Spring WebFlux", FrameworkCategory.APPLICATION),
  PLAY_FRAMEWORK("Play Framework", FrameworkCategory.APPLICATION),
  DJANGO("Django", FrameworkCategory.APPLICATION),
  FLASK("Flask", FrameworkCategory.APPLICATION),
  FASTAPI("FastAPI", FrameworkCategory.APPLICATION),

  // Data
  SPRING_DATA("Spring Data", FrameworkCategory.DATA),

  // Security
  SPRING_SECURITY("Spring Security", FrameworkCategory.SECURITY),

  // Testing
  PLAYWRIGHT("Playwright", FrameworkCategory.TESTING),
  JUNIT("JUnit", FrameworkCategory.TESTING),

  // UI
  TAILWIND("Tailwind CSS", FrameworkCategory.UI),
}

enum class FrameworkCategory(val title: String) {
  APPLICATION("Application"),
  DATA("Data"),
  SECURITY("Security"),
  TESTING("Testing"),
  UI("UI"),
}
