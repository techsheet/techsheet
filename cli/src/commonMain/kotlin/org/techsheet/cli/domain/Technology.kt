package org.techsheet.cli.domain

data class Technology(
  val type: TechnologyType,
  val version: String?,
)

enum class TechnologyType(val title: String, val category: TechnologyCategory) {

  // Frameworks
  ANGULAR("Angular", TechnologyCategory.FRAMEWORK),
  REACT("React", TechnologyCategory.FRAMEWORK),
  VUE("Vue.js", TechnologyCategory.FRAMEWORK),
  SVELTE("Svelte", TechnologyCategory.FRAMEWORK),
  NEXT("Next.js", TechnologyCategory.FRAMEWORK),
  EXPRESS("Express", TechnologyCategory.FRAMEWORK),
  QT("Qt", TechnologyCategory.FRAMEWORK),
  SPRING_BOOT("Spring Boot", TechnologyCategory.FRAMEWORK),
  SPRING_MVC("Spring MVC", TechnologyCategory.FRAMEWORK),
  SPRING_WEBFLUX("Spring WebFlux", TechnologyCategory.FRAMEWORK),
  SPRING_SECURITY("Spring Security", TechnologyCategory.FRAMEWORK),
  SPRING_DATA("Spring Data", TechnologyCategory.FRAMEWORK),
  PLAY_FRAMEWORK("Play Framework", TechnologyCategory.FRAMEWORK),
  DJANGO("Django", TechnologyCategory.FRAMEWORK),
  FLASK("Flask", TechnologyCategory.FRAMEWORK),
  FASTAPI("FastAPI", TechnologyCategory.FRAMEWORK),

  // Testing
  PLAYWRIGHT("Playwright", TechnologyCategory.TESTING),
  JUNIT("JUnit", TechnologyCategory.TESTING),

  // Libraries
  TAILWIND("Tailwind CSS", TechnologyCategory.LIBRARY),
}

enum class TechnologyCategory(val title: String) {
  FRAMEWORK("Framework"),
  LIBRARY("Library"),
  TESTING("Testing"),
}
