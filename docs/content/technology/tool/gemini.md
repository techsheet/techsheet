---
title: Gemini
aliases:
  - /tool/gemini
bookToC: false
techsheet:
  key: gemini
  type: tool
  category: AI
  related:
    - type: tool
      key: claude
      comment: "alternative AI assistant and coding agent"
    - type: tool
      key: github-copilot
      comment: "alternative AI coding assistant"
    - type: tool
      key: cursor
      comment: "AI-powered IDE with Gemini model support"
    - type: tool
      key: codex
      comment: "alternative AI coding agent"
---

**A family of multimodal AI models developed by Google DeepMind, powering coding assistance, conversational AI, and
developer tooling across Google's ecosystem.**

Gemini is Google's flagship large language model series, designed from the ground up as a natively multimodal system
capable of reasoning across text, code, images, audio, and video. The model family spans multiple size tiers (Ultra,
Pro,
Flash, Nano) to address different latency, cost, and capability requirements. Gemini's architecture uses a mixture of
experts and supports extended context windows of up to two million tokens in its largest configurations. The models are
accessible through the Gemini API (via Google AI Studio) and Vertex AI on Google Cloud, with structured output, function
calling, and grounding through Google Search as core integration primitives.

In software development, Gemini powers coding features in [GitHub Copilot](github-copilot.md) as a
selectable model backend and is deeply integrated into Android Studio and the broader JetBrains plugin ecosystem through
the Gemini Code Assist product. Google also offers Gemini as an agentic coding tool through Jules, a cloud-based agent
for asynchronous code tasks. The model family competes directly with [Claude](claude.md) and
[OpenAI Codex](codex.md) in the AI-assisted development space. TechSheet detects Gemini through the
presence of configuration files such as .gemini/ directories or gemini.md project instructions.

## Further Information

- [deepmind.google/gemini](https://deepmind.google/technologies/gemini/)
- [Google AI Studio](https://aistudio.google.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/Gemini_(language_model))
