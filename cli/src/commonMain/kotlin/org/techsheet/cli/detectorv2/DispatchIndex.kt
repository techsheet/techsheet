package org.techsheet.cli.detectorv2

class DispatchIndex(detectors: List<Detector>) {

  private val byFilename: Map<String, List<Detector>> =
    indexBy<Matcher.Filename>(detectors) { it.name }

  private val byExtension: Map<String, List<Detector>> =
    indexBy<Matcher.Extension>(detectors) { it.ext }

  private val byFileAt: Map<String, List<Detector>> =
    indexBy<Matcher.FileAt>(detectors) { keyOf(it.segments) }

  private val byDirectoryAt: Map<String, List<Detector>> =
    indexBy<Matcher.DirectoryAt>(detectors) { keyOf(it.segments) }

  fun forFile(relativePath: String, filename: String, extension: String?): List<Detector> =
    buildList {
      byFileAt[relativePath]?.let(::addAll)
      byFilename[filename]?.let(::addAll)
      extension?.let(byExtension::get)?.let(::addAll)
    }.distinct()

  fun forDirectory(relativePath: String): List<Detector> =
    byDirectoryAt[relativePath].orEmpty()

  private companion object {
    inline fun <reified M : Matcher> indexBy(
      detectors: List<Detector>,
      crossinline key: (M) -> String,
    ): Map<String, List<Detector>> = detectors
      .flatMap { d -> d.matchers.filterIsInstance<M>().map { key(it) to d } }
      .groupBy({ it.first }, { it.second })

    fun keyOf(segments: List<String>): String = segments.joinToString("/")
  }
}
