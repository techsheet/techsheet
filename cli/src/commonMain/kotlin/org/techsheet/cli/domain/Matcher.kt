package org.techsheet.cli.domain

sealed interface Matcher {
  data class Filename(val name: String) : Matcher
  data class Extension(val ext: String) : Matcher

  data class FileAt(val segments: List<String>) : Matcher {
    constructor(vararg segments: String) : this(segments.toList())
  }

  data class DirectoryAt(val segments: List<String>) : Matcher {
    constructor(vararg segments: String) : this(segments.toList())
  }
}
