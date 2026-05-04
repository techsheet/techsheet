package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class CudaDetector : AbstractLanguageDetector(
  name = "CUDA",
  type = LanguageType.CUDA,
  ".cu", ".cuh",
)
