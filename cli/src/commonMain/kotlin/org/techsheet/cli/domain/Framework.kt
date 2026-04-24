package org.techsheet.cli.domain

data class Framework(
  val type: FrameworkType,
  val version: String?,
)

enum class FrameworkType(
  override val key: String,
  override val title: String,
  val category: FrameworkCategory,
  val languages: List<LanguageType> = emptyList(),
) : Technology {

  // Application
  ANGULAR("angular", "Angular", FrameworkCategory.APPLICATION, listOf(LanguageType.TYPESCRIPT)),
  REACT("react", "React", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVASCRIPT, LanguageType.TYPESCRIPT)),
  VUE("vue", "Vue.js", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVASCRIPT, LanguageType.TYPESCRIPT)),
  SVELTE("svelte", "Svelte", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVASCRIPT, LanguageType.TYPESCRIPT)),
  NEXT("nextjs", "Next.js", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVASCRIPT, LanguageType.TYPESCRIPT)),
  EXPRESS("express", "Express", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVASCRIPT, LanguageType.TYPESCRIPT)),
  QT("qt", "Qt", FrameworkCategory.APPLICATION, listOf(LanguageType.CPP, LanguageType.PYTHON)),
  ASP_NET_CORE("asp-net-core", "ASP.NET Core", FrameworkCategory.APPLICATION, listOf(LanguageType.CSHARP)),
  SPRING_BOOT("spring-boot", "Spring Boot", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  SPRING_MVC("spring-mvc", "Spring MVC", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  SPRING_WEBFLUX("spring-webflux", "Spring WebFlux", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  PLAY_FRAMEWORK("play-framework", "Play Framework", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA, LanguageType.SCALA)),
  LARAVEL("laravel", "Laravel", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  SYMFONY("symfony", "Symfony", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  CODEIGNITER("codeigniter", "CodeIgniter", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  ZEND_FRAMEWORK("zend-framework", "Zend Framework", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  YII2("yii2", "Yii2", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  CAKEPHP("cakephp", "CakePHP", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  SLIM("slim", "Slim", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  PHALCON("phalcon", "Phalcon", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  LUMEN("lumen", "Lumen", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  FUELPHP("fuelphp", "FuelPHP", FrameworkCategory.APPLICATION, listOf(LanguageType.PHP)),
  DJANGO("django", "Django", FrameworkCategory.APPLICATION, listOf(LanguageType.PYTHON)),
  FLASK("flask", "Flask", FrameworkCategory.APPLICATION, listOf(LanguageType.PYTHON)),
  FASTAPI("fastapi", "FastAPI", FrameworkCategory.APPLICATION, listOf(LanguageType.PYTHON)),
  KTOR("ktor", "Ktor", FrameworkCategory.APPLICATION, listOf(LanguageType.KOTLIN)),
  QUARKUS("quarkus", "Quarkus", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  MICRONAUT("micronaut", "Micronaut", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  STRUTS("struts", "Struts", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA)),
  VERTX("vertx", "Vert.x", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  JAKARTA_EE("jakarta-ee", "Jakarta EE", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA)),
  DROPWIZARD("dropwizard", "Dropwizard", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA)),
  HELIDON("helidon", "Helidon", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  JAVALIN("javalin", "Javalin", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  AKKA_HTTP("akka-http", "Akka HTTP", FrameworkCategory.APPLICATION, listOf(LanguageType.SCALA, LanguageType.JAVA)),
  HTTP4S("http4s", "http4s", FrameworkCategory.APPLICATION, listOf(LanguageType.SCALA)),
  APACHE_CXF("apache-cxf", "Apache CXF", FrameworkCategory.APPLICATION, listOf(LanguageType.JAVA)),

  // CMS
  WORDPRESS("wordpress", "WordPress", FrameworkCategory.CMS, listOf(LanguageType.PHP)),
  JOOMLA("joomla", "Joomla", FrameworkCategory.CMS, listOf(LanguageType.PHP)),
  DRUPAL("drupal", "Drupal", FrameworkCategory.CMS, listOf(LanguageType.PHP)),
  MAGENTO("magento", "Magento", FrameworkCategory.CMS, listOf(LanguageType.PHP)),
  TYPO3("typo3", "TYPO3", FrameworkCategory.CMS, listOf(LanguageType.PHP)),
  CONTAO("contao", "Contao", FrameworkCategory.CMS, listOf(LanguageType.PHP)),
  MODX("modx", "MODX", FrameworkCategory.CMS, listOf(LanguageType.PHP)),
  GRAV("grav", "Grav", FrameworkCategory.CMS, listOf(LanguageType.PHP)),
  CONCRETE_CMS("concrete-cms", "Concrete CMS", FrameworkCategory.CMS, listOf(LanguageType.PHP)),
  CRAFT_CMS("craft-cms", "Craft CMS", FrameworkCategory.CMS, listOf(LanguageType.PHP)),

  // Concurrency
  PROJECT_REACTOR("reactor", "Project Reactor", FrameworkCategory.CONCURRENCY, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  RXJAVA("rxjava", "RxJava", FrameworkCategory.CONCURRENCY, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  KOTLINX_COROUTINES("kotlinx-coroutines", "Kotlinx Coroutines", FrameworkCategory.CONCURRENCY, listOf(LanguageType.KOTLIN)),
  AKKA("akka", "Akka", FrameworkCategory.CONCURRENCY, listOf(LanguageType.SCALA, LanguageType.JAVA)),
  ZIO("zio", "ZIO", FrameworkCategory.CONCURRENCY, listOf(LanguageType.SCALA)),
  CATS_EFFECT("cats-effect", "Cats Effect", FrameworkCategory.CONCURRENCY, listOf(LanguageType.SCALA)),
  ARROW("arrow", "Arrow", FrameworkCategory.CONCURRENCY, listOf(LanguageType.KOTLIN)),
  REACTPHP("reactphp", "ReactPHP", FrameworkCategory.CONCURRENCY, listOf(LanguageType.PHP)),

  // Data
  SPRING_DATA("spring-data", "Spring Data", FrameworkCategory.DATA, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  DOCTRINE("doctrine", "Doctrine", FrameworkCategory.DATA, listOf(LanguageType.PHP)),
  ELOQUENT("eloquent", "Eloquent", FrameworkCategory.DATA, listOf(LanguageType.PHP)),
  EXPOSED("exposed", "Exposed", FrameworkCategory.DATA, listOf(LanguageType.KOTLIN)),
  HIBERNATE("hibernate", "Hibernate", FrameworkCategory.DATA, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  JOOQ("jooq", "jOOQ", FrameworkCategory.DATA, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  SLICK("slick", "Slick", FrameworkCategory.DATA, listOf(LanguageType.SCALA)),
  MYBATIS("mybatis", "MyBatis", FrameworkCategory.DATA, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  EBEAN("ebean", "Ebean", FrameworkCategory.DATA, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  KTORM("ktorm", "Ktorm", FrameworkCategory.DATA, listOf(LanguageType.KOTLIN)),
  KAFKA("kafka", "Apache Kafka", FrameworkCategory.DATA, listOf(LanguageType.JAVA, LanguageType.KOTLIN, LanguageType.SCALA)),

  // Logging
  SLF4J("slf4j", "SLF4J", FrameworkCategory.LOGGING, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  LOGBACK("logback", "Logback", FrameworkCategory.LOGGING, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  LOG4J2("log4j2", "Log4j2", FrameworkCategory.LOGGING, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  MONOLOG("monolog", "Monolog", FrameworkCategory.LOGGING, listOf(LanguageType.PHP)),

  // Security
  SPRING_SECURITY("spring-security", "Spring Security", FrameworkCategory.SECURITY, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),

  // Testing
  PLAYWRIGHT("playwright", "Playwright", FrameworkCategory.TESTING, listOf(LanguageType.JAVASCRIPT, LanguageType.TYPESCRIPT, LanguageType.PYTHON, LanguageType.JAVA, LanguageType.CSHARP)),
  PHPUNIT("phpunit", "PHPUnit", FrameworkCategory.TESTING, listOf(LanguageType.PHP)),
  JUNIT("junit", "JUnit", FrameworkCategory.TESTING, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  MOCKITO("mockito", "Mockito", FrameworkCategory.TESTING, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  ASSERTJ("assertj", "AssertJ", FrameworkCategory.TESTING, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  KOTEST("kotest", "Kotest", FrameworkCategory.TESTING, listOf(LanguageType.KOTLIN)),
  SCALATEST("scalatest", "ScalaTest", FrameworkCategory.TESTING, listOf(LanguageType.SCALA)),
  SPOCK("spock", "Spock", FrameworkCategory.TESTING, listOf(LanguageType.GROOVY)),
  TESTNG("testng", "TestNG", FrameworkCategory.TESTING, listOf(LanguageType.JAVA)),
  TESTCONTAINERS("testcontainers", "Testcontainers", FrameworkCategory.TESTING, listOf(LanguageType.JAVA, LanguageType.KOTLIN, LanguageType.PYTHON)),
  WIREMOCK("wiremock", "WireMock", FrameworkCategory.TESTING, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),
  REST_ASSURED("rest-assured", "REST Assured", FrameworkCategory.TESTING, listOf(LanguageType.JAVA, LanguageType.KOTLIN)),

  // UI
  TAILWIND("tailwind", "Tailwind CSS", FrameworkCategory.UI, listOf(LanguageType.CSS));

  override val type: String = "framework"
}

enum class FrameworkCategory(val title: String) {
  APPLICATION("Application"),
  CMS("CMS"),
  CONCURRENCY("Concurrency"),
  DATA("Data"),
  LOGGING("Logging"),
  SECURITY("Security"),
  TESTING("Testing"),
  UI("UI"),
}
