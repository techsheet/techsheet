package org.techsheet.cli.util

import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char
import kotlinx.datetime.offsetAt
import kotlin.time.Instant

internal val DEFAULT_DATE_TIME_FORMAT: DateTimeFormat<DateTimeComponents> = DateTimeComponents.Format {
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

internal fun Instant.formatDefault(): String =
  format(DEFAULT_DATE_TIME_FORMAT, TimeZone.currentSystemDefault().offsetAt(this))
