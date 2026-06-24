---
title: Awk
aliases:
  - /language/awk
bookToC: false
techsheet:
  key: awk
  type: language
  related:
    - type: language
      key: shell
      comment: "commonly embedded in shell scripts"
    - type: language
      key: perl
      comment: "absorbed many awk use cases for larger programs"
---

**A pattern-scanning and text-processing language designed for extracting and transforming structured data from text
streams and files.**

Awk is a data-driven programming language built around a pattern-action model: each line of input is tested against a
series of patterns, and the associated action block executes when a match occurs. It automatically splits input records
into fields by a configurable separator, making column-oriented data manipulation concise and expressive. The language
supports associative arrays, regular expressions, printf-style formatting, and user-defined functions, while maintaining
a deliberately small feature set that favors one-liner and short-program use cases. Variables are untyped, with
automatic coercion between strings and numbers depending on context.

Originally developed at Bell Labs by Aho, Weinberger, and Kernighan in 1977, Awk became a standard Unix text-processing
tool and is specified by POSIX. The GNU implementation (gawk) extends the language with network I/O, multidimensional
arrays, and namespace support. Awk programs are commonly embedded in [Shell](shell.md) scripts and
Makefiles for log analysis,
CSV processing, report generation, and configuration file manipulation. While [Perl](perl.md) and
Python absorbed many of its
use cases for larger programs, Awk remains widely used for concise field-oriented transformations where its implicit
input loop and field-splitting semantics provide unmatched brevity.

## Further Information

- [GNU Awk User's Guide](https://www.gnu.org/software/gawk/manual/)
- [Wikipedia](https://en.wikipedia.org/wiki/AWK)
