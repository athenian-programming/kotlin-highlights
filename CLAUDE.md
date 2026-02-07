# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Kotlin Highlights is an educational project with runnable examples demonstrating Kotlin language features. It includes
numbered tutorial files (1-23) progressing from basics to advanced topics, plus a MkDocs-based documentation website
hosted at https://kotlin-highlights.netlify.com.

## Build Commands

- `./gradlew build` (or `make build`) — Build the project (also cleans the site dir)
- `./gradlew dependencyUpdates` (or `make versioncheck`) — Check for dependency updates
- `./gradlew --refresh-dependencies` (or `make refresh`) — Refresh Gradle dependencies
- `make serve` — Serve documentation locally with MkDocs
- `make website` — Build documentation site
- `make upgrade-wrapper` — Upgrade Gradle wrapper version

There are no tests in this project. `./gradlew build` compiles all sources.

## Build Configuration

- **Build system:** Gradle (wrapper included)
- **Kotlin JVM toolchain:** Java 17
- **Dependency versions** are centralized in `gradle/libs.versions.toml` (Kotlin, Ktor, logging libraries, plugins)
- **Key dependencies:** Ktor (server, CIO, sessions, HTML builder), kotlin-logging, logback, slf4j
- **Compiler opt-ins:** `kotlin.time.ExperimentalTime`, `kotlinx.serialization.UnstableDefault`

## Code Structure

- `src/main/kotlin/org/athenian/` — Numbered tutorial examples (1-hello.kt through 23-lambda-exercises.kt), plus
  delegate examples (lazy, map, standard, user delegates)
- `src/main/kotlin/snippets/` — Concise standalone pattern examples (DSLs, extension functions, scope functions,
  operator overloading, etc.)
- `docs/` — MkDocs documentation source (Markdown files for sequences, scope functions, delegates)
- `mkdocs.yml` — Documentation site configuration (Material theme)

## Architecture Notes

- Each numbered file in `org/athenian/` has its own `main()` function and is independently runnable
- Files in `snippets/` also have independent `main()` functions
- There is no application entry point or shared runtime — this is a collection of standalone examples
- The project uses Ktor only for web server demonstration examples, not as a core framework