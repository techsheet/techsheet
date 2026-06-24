package org.techsheet.analyzer

import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.core.subcommands

fun main(args: Array<String>) =
  TechsheetCli()
    .subcommands(AnalyzerCommand(), InitCommand())
    .main(args)
