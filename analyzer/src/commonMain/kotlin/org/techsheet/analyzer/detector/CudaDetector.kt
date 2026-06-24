package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class CudaDetector : AbstractLanguageDetector(
  name = "CUDA",
  type = LanguageType.CUDA,
  ".cu", ".cuh",
)
