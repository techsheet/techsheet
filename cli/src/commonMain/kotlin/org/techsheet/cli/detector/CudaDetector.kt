package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class CudaDetector : AbstractSourceFileLanguageDetector(
  name = "CUDA",
  type = LanguageType.CUDA,
  ".cu", ".cuh",
)
