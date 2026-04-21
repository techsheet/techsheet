package org.techsheet.cli.domain

private val SEMVER_LIKE = Regex("""^\d+(\.\d+)*(-.*)?$""")

internal fun isSemverLike(version: String): Boolean = SEMVER_LIKE.matches(version)

internal fun pickVersion(left: String?, right: String?): String? = when {
  left == null -> right
  right == null -> left
  isSemverLike(left) && isSemverLike(right) ->
    if (compareSemver(left, right) >= 0) left else right
  isSemverLike(left) -> left
  isSemverLike(right) -> right
  else -> left
}

private fun compareSemver(a: String, b: String): Int =
  (numericComponents(a) to numericComponents(b))
    .let { (aNums, bNums) ->
      val width = maxOf(aNums.size, bNums.size)
      (0 until width).asSequence()
        .map { aNums.getOrElse(it) { 0 }.compareTo(bNums.getOrElse(it) { 0 }) }
        .firstOrNull { it != 0 }
        ?: 0
    }

private fun numericComponents(version: String): List<Int> =
  version.substringBefore('-')
    .split('.')
    .map { it.toIntOrNull() ?: 0 }
