package org.techsheet.cli

import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.core.subcommands

fun main(args: Array<String>) =
  TechsheetCli()
    .subcommands(AnalyzeCommand())
    .main(args)
