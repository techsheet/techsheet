package org.techsheet.cli.domain

data class Framework(
  val type: FrameworkType,
  val version: String?,
)

enum class FrameworkType(
  val title: String,
  val url: String,
  val category: FrameworkCategory
) {

  // Application
  ANGULAR("Angular", "https://techsheet.org/framework/angular", FrameworkCategory.APPLICATION),
  REACT("React", "https://techsheet.org/framework/react", FrameworkCategory.APPLICATION),
  VUE("Vue.js", "https://techsheet.org/framework/vue", FrameworkCategory.APPLICATION),
  SVELTE("Svelte", "https://techsheet.org/framework/svelte", FrameworkCategory.APPLICATION),
  NEXT("Next.js", "https://techsheet.org/framework/nextjs", FrameworkCategory.APPLICATION),
  EXPRESS("Express", "https://techsheet.org/framework/express", FrameworkCategory.APPLICATION),
  QT("Qt", "https://techsheet.org/framework/qt", FrameworkCategory.APPLICATION),
  ASP_NET_CORE("ASP.NET Core", "https://techsheet.org/framework/asp-net-core", FrameworkCategory.APPLICATION),
  SPRING_BOOT("Spring Boot", "https://techsheet.org/framework/spring-boot", FrameworkCategory.APPLICATION),
  SPRING_MVC("Spring MVC", "https://techsheet.org/framework/spring-mvc", FrameworkCategory.APPLICATION),
  SPRING_WEBFLUX("Spring WebFlux", "https://techsheet.org/framework/spring-webflux", FrameworkCategory.APPLICATION),
  PLAY_FRAMEWORK("Play Framework", "https://techsheet.org/framework/play-framework", FrameworkCategory.APPLICATION),
  DJANGO("Django", "https://techsheet.org/framework/django", FrameworkCategory.APPLICATION),
  FLASK("Flask", "https://techsheet.org/framework/flask", FrameworkCategory.APPLICATION),
  FASTAPI("FastAPI", "https://techsheet.org/framework/fastapi", FrameworkCategory.APPLICATION),

  // Data
  SPRING_DATA("Spring Data", "https://techsheet.org/framework/spring-data", FrameworkCategory.DATA),

  // Security
  SPRING_SECURITY("Spring Security", "https://techsheet.org/framework/spring-security", FrameworkCategory.SECURITY),

  // Testing
  PLAYWRIGHT("Playwright", "https://techsheet.org/framework/playwright", FrameworkCategory.TESTING),
  JUNIT("JUnit", "https://techsheet.org/framework/junit", FrameworkCategory.TESTING),

  // UI
  TAILWIND("Tailwind CSS", "https://techsheet.org/framework/tailwind", FrameworkCategory.UI),
}

enum class FrameworkCategory(val title: String) {
  APPLICATION("Application"),
  DATA("Data"),
  SECURITY("Security"),
  TESTING("Testing"),
  UI("UI"),
}
