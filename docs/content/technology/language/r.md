---
title: "R"
aliases:
- "/language/r"
bookToC: false
techsheet:
  key: "r"
  type: "language"
  related:
  - type: "language"
    key: "python"
    comment: "primary alternative for data science"
  - type: "language"
    key: "julia"
    comment: "modern alternative for scientific computing"
  - type: "language"
    key: "sql"
    comment: "commonly used together for data access"
  - type: "language"
    key: "fortran"
    comment: "heritage in numerical computing"
---

**A programming language and environment designed for statistical computing, data analysis, and graphical visualization.
**

R is a dynamically typed, interpreted language that descends from the S language developed at Bell Laboratories in the
1970s. It provides a wide array of built-in statistical and numerical methods, including linear and nonlinear modeling,
time-series analysis, classification, clustering, and hypothesis testing. The language treats vectors as first-class
objects, supports lazy evaluation of function arguments, and uses a copy-on-modify memory semantics. Its formula
interface and factor data type make expressing statistical models concise and idiomatic. CRAN (Comprehensive R Archive
Network) hosts over 20,000 contributed packages, giving the language one of the deepest ecosystems for domain-specific
statistical methods.

The language dominates academic statistics, bioinformatics (via Bioconductor), and exploratory data analysis across the
social and natural sciences. The tidyverse family of packages, especially ggplot2 and dplyr, has shaped modern
data-wrangling practice and influenced tooling in other languages like [Python](python.md). RStudio (
now Posit) provides the primary IDE, and R Markdown / Quarto enable reproducible research documents that interleave
code, results, and narrative. Recent development has focused on improved performance through ALTREP (alternative
representations of R objects), tighter integration with Apache Arrow for large-dataset interoperability, and expanded
support for [Python](python.md) interop via the reticulate package.

## Further Information

- [r-project.org](https://www.r-project.org/)
- [CRAN](https://cran.r-project.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/R_(programming_language))
