---
title: "CUDA"
aliases:
- "/language/cuda"
bookToC: false
techsheet:
  key: "cuda"
  type: "language"
  related:
  - type: "language"
    key: "cpp"
    comment: "host language it extends"
  - type: "language"
    key: "python"
    comment: "primary high-level binding ecosystem"
  - type: "language"
    key: "fortran"
    comment: "CUDA Fortran support"
---

**A parallel computing platform and programming model that extends [C++](cpp.md) for general-purpose
computation on NVIDIA GPUs.**

CUDA (Compute Unified Device Architecture) enables developers to write kernels that execute across thousands of GPU
threads simultaneously. It extends [C++](cpp.md) with language constructs for defining kernel
functions (`__global__`, `__device__`), managing device memory, and configuring thread hierarchies organized as grids of
thread blocks. The programming model abstracts the GPU's streaming multiprocessors through a SIMT (Single Instruction,
Multiple Threads) execution model, and the CUDA toolkit provides compilers (nvcc), profilers, math libraries (cuBLAS,
cuFFT, cuDNN), and runtime APIs for memory management and stream-based concurrency.

The platform underpins the modern deep learning ecosystem, with frameworks like PyTorch and TensorFlow relying on CUDA
for GPU-accelerated training and inference. It is equally central to scientific computing (molecular dynamics,
computational fluid dynamics), financial modeling, and image processing. [Python](python.md) bindings
through CuPy, Numba, and PyCUDA have made GPU programming accessible beyond [C++](cpp.md), while
NVIDIA's continued hardware-software co-design (Tensor Cores, NVLink, CUDA Graphs) has kept the platform tightly coupled
to each new GPU architecture generation.

## Further Information

- [developer.nvidia.com/cuda-toolkit](https://developer.nvidia.com/cuda-toolkit)
- [CUDA C++ Programming Guide](https://docs.nvidia.com/cuda/cuda-c-programming-guide/)
- [Wikipedia](https://en.wikipedia.org/wiki/CUDA)
