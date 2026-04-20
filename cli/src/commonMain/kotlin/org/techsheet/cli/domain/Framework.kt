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
  KTOR("Ktor", "https://techsheet.org/framework/ktor", FrameworkCategory.APPLICATION),
  QUARKUS("Quarkus", "https://techsheet.org/framework/quarkus", FrameworkCategory.APPLICATION),
  MICRONAUT("Micronaut", "https://techsheet.org/framework/micronaut", FrameworkCategory.APPLICATION),
  STRUTS("Struts", "https://techsheet.org/framework/struts", FrameworkCategory.APPLICATION),
  VERTX("Vert.x", "https://techsheet.org/framework/vertx", FrameworkCategory.APPLICATION),
  JAKARTA_EE("Jakarta EE", "https://techsheet.org/framework/jakarta-ee", FrameworkCategory.APPLICATION),
  DROPWIZARD("Dropwizard", "https://techsheet.org/framework/dropwizard", FrameworkCategory.APPLICATION),
  HELIDON("Helidon", "https://techsheet.org/framework/helidon", FrameworkCategory.APPLICATION),
  JAVALIN("Javalin", "https://techsheet.org/framework/javalin", FrameworkCategory.APPLICATION),
  AKKA_HTTP("Akka HTTP", "https://techsheet.org/framework/akka-http", FrameworkCategory.APPLICATION),
  HTTP4S("http4s", "https://techsheet.org/framework/http4s", FrameworkCategory.APPLICATION),
  APACHE_CXF("Apache CXF", "https://techsheet.org/framework/apache-cxf", FrameworkCategory.APPLICATION),

  // Concurrency
  PROJECT_REACTOR("Project Reactor", "https://techsheet.org/framework/reactor", FrameworkCategory.CONCURRENCY),
  RXJAVA("RxJava", "https://techsheet.org/framework/rxjava", FrameworkCategory.CONCURRENCY),
  KOTLINX_COROUTINES("Kotlinx Coroutines", "https://techsheet.org/framework/kotlinx-coroutines", FrameworkCategory.CONCURRENCY),
  AKKA("Akka", "https://techsheet.org/framework/akka", FrameworkCategory.CONCURRENCY),
  ZIO("ZIO", "https://techsheet.org/framework/zio", FrameworkCategory.CONCURRENCY),
  CATS_EFFECT("Cats Effect", "https://techsheet.org/framework/cats-effect", FrameworkCategory.CONCURRENCY),
  ARROW("Arrow", "https://techsheet.org/framework/arrow", FrameworkCategory.CONCURRENCY),

  // Data
  SPRING_DATA("Spring Data", "https://techsheet.org/framework/spring-data", FrameworkCategory.DATA),
  EXPOSED("Exposed", "https://techsheet.org/framework/exposed", FrameworkCategory.DATA),
  HIBERNATE("Hibernate", "https://techsheet.org/framework/hibernate", FrameworkCategory.DATA),
  JOOQ("jOOQ", "https://techsheet.org/framework/jooq", FrameworkCategory.DATA),
  SLICK("Slick", "https://techsheet.org/framework/slick", FrameworkCategory.DATA),
  MYBATIS("MyBatis", "https://techsheet.org/framework/mybatis", FrameworkCategory.DATA),
  EBEAN("Ebean", "https://techsheet.org/framework/ebean", FrameworkCategory.DATA),
  KTORM("Ktorm", "https://techsheet.org/framework/ktorm", FrameworkCategory.DATA),
  KAFKA("Apache Kafka", "https://techsheet.org/framework/kafka", FrameworkCategory.DATA),

  // Logging
  SLF4J("SLF4J", "https://techsheet.org/framework/slf4j", FrameworkCategory.LOGGING),
  LOGBACK("Logback", "https://techsheet.org/framework/logback", FrameworkCategory.LOGGING),
  LOG4J2("Log4j2", "https://techsheet.org/framework/log4j2", FrameworkCategory.LOGGING),

  // Security
  SPRING_SECURITY("Spring Security", "https://techsheet.org/framework/spring-security", FrameworkCategory.SECURITY),

  // Testing
  PLAYWRIGHT("Playwright", "https://techsheet.org/framework/playwright", FrameworkCategory.TESTING),
  JUNIT("JUnit", "https://techsheet.org/framework/junit", FrameworkCategory.TESTING),
  MOCKITO("Mockito", "https://techsheet.org/framework/mockito", FrameworkCategory.TESTING),
  ASSERTJ("AssertJ", "https://techsheet.org/framework/assertj", FrameworkCategory.TESTING),
  KOTEST("Kotest", "https://techsheet.org/framework/kotest", FrameworkCategory.TESTING),
  SCALATEST("ScalaTest", "https://techsheet.org/framework/scalatest", FrameworkCategory.TESTING),
  SPOCK("Spock", "https://techsheet.org/framework/spock", FrameworkCategory.TESTING),
  TESTNG("TestNG", "https://techsheet.org/framework/testng", FrameworkCategory.TESTING),
  TESTCONTAINERS("Testcontainers", "https://techsheet.org/framework/testcontainers", FrameworkCategory.TESTING),
  WIREMOCK("WireMock", "https://techsheet.org/framework/wiremock", FrameworkCategory.TESTING),
  REST_ASSURED("REST Assured", "https://techsheet.org/framework/rest-assured", FrameworkCategory.TESTING),

  // UI
  TAILWIND("Tailwind CSS", "https://techsheet.org/framework/tailwind", FrameworkCategory.UI),
}

enum class FrameworkCategory(val title: String) {
  APPLICATION("Application"),
  CONCURRENCY("Concurrency"),
  DATA("Data"),
  LOGGING("Logging"),
  SECURITY("Security"),
  TESTING("Testing"),
  UI("UI"),
}
