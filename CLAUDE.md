# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java library for generating "Cadena Original" (original chain) from Mexican CFDI (Comprobante Fiscal Digital por Internet) XML documents. It uses XSLT transformations to extract and format data from CFDI invoices according to SAT (Mexican tax authority) specifications.

**Maven coordinates:** `mx.com.sw.services:sw-resources-java`

## Build Commands

```bash
# Compile and package
mvn package

# Run all tests
mvn test

# Run a single test class
mvn -Dtest=CadenaOriginalCfdi40Test test

# Clean and build
mvn clean package

# Build with dependencies JAR
mvn package  # produces target/sw-resources-java-{version}-jar-with-dependencies.jar

# Release build (requires GPG signing)
mvn clean deploy -Prelease
```

## Architecture

### Core Classes

- **`CadenaOriginalCfdi`** - Main entry point with static methods. Auto-detects CFDI version from XML and delegates to appropriate version-specific handler.
- **`CadenaOriginalCfdiBase`** - Abstract base class that handles XSLT transformation. Loads XSLT templates and provides `getCadenaOriginal()` methods.
- **`CadenaOriginalCfdi32/33/40`** - Version-specific implementations that extend the base class with appropriate XSLT paths.

### Singleton Pattern

The `sw.Singleton` package contains singleton wrappers (`CadenaOriginalCfdi32Singleton`, etc.) for efficient reuse of XSLT templates. Use `CadenaOriginalCfdi.warmUp()` to pre-initialize all singletons.

### XSLT Resources

XSLT templates are in `src/main/resources/`:
- `/cfdi32/` - CFDI 3.2 transformations
- `/cfdi33/` - CFDI 3.3 transformations
- `/cfdi40/` - CFDI 4.0 transformations (includes CartaPorte complements)

### Helper Classes

- **`XmlUtils`** - XML parsing utilities including version detection via `getCfdiVersion()`.

## Usage Pattern

```java
// Auto-detect version
byte[] xmlBytes = Files.readAllBytes(path);
String cadena = CadenaOriginalCfdi.getCadenaOriginal(xmlBytes);

// Explicit version
String cadena = CadenaOriginalCfdi.getCadenaOriginal(xmlBytes, "4.0");
```

## Test Resources

Test XML files are in `src/test/resources/` (e.g., `cfdi40_01.xml`).
