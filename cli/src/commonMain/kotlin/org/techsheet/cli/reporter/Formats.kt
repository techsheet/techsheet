package org.techsheet.cli.reporter

import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char
import kotlinx.datetime.offsetAt
import kotlin.time.Instant

/**
 * Project-wide human-readable timestamp format used for any date/time shown to a person
 * (e.g. report meta lines). Renders in the system's local time zone.
 *
 * Example: `21. April 2026 17:37`.
 */
internal val HUMAN_DATE_TIME: DateTimeFormat<DateTimeComponents> = DateTimeComponents.Format {
  day(Padding.NONE)
  chars(". ")
  monthName(MonthNames.ENGLISH_FULL)
  char(' ')
  year()
  char(' ')
  hour()
  char(':')
  minute()
}

internal fun Instant.formatHuman(): String =
  format(HUMAN_DATE_TIME, TimeZone.currentSystemDefault().offsetAt(this))

