# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java learning project from Diginamic focusing on imperative programming approaches. The codebase contains educational exercises and implementations demonstrating core Java concepts including object-oriented programming, algorithms, data structures, and console-based applications.

## Build and Development Commands

This project uses a basic Java compilation approach without build tools like Maven or Gradle:

- **Compile all Java files**: `javac -d out/production/approche-imperative src/fr/diginamic/**/*.java`
- **Run a specific class**: `java -cp out/production/approche-imperative fr.diginamic.packagename.ClassName`
- **Run from source directory**: Use IntelliJ IDEA or Eclipse IDE (project appears to be configured for IntelliJ)

Note: No automated testing framework, linting, or build scripts are configured in this educational project.

## Code Architecture

### Package Structure
- `fr.diginamic.chaine`: String manipulation utilities and employee entities
- `fr.diginamic.combat`: RPG combat system with characters, creatures, and potions
- `fr.diginamic.essais`: Test classes for various components (manual testing approach)
- `fr.diginamic.maison`: House management system with room types and area calculations  
- `fr.diginamic.operations`: Mathematical operations utility classes

### Key Architectural Patterns
- **Object-Oriented Design**: Heavy use of inheritance, polymorphism, and encapsulation
- **Package-based Organization**: Logical separation by functionality
- **Manual Testing**: Test classes in `essais` package provide example usage and validation
- **Console-based Applications**: All programs are command-line interfaces with Scanner input

### Notable Implementations
- **Combat System**: Turn-based RPG with character creation, creature battles, and potion mechanics
- **House Management**: Room hierarchy with different types (Chambre, Cuisine, SalleDeBain, etc.)
- **Mathematical Operations**: Calculator with basic arithmetic and error handling
- **String Processing**: Text manipulation utilities with employee data handling

## Development Notes

- This is an educational codebase focused on learning Java fundamentals
- Code includes French comments except variable/method names in english (learning context in French)
- Most classes have corresponding test classes in the `essais` package
- The project emphasizes imperative programming patterns over modern Java frameworks
- Output directory structure mirrors the source package hierarchy

## Code Style & Architecture Standards
* Variables: camelCase
* Functions: camelCase with verbs
* Classes: PascalCase
* Constants: SCREAMING_SNAKE_CASE
* Files: kebab-case or camelCase (team preference)
* Import/Export rules: Preferred module import/export syntax
* Architecture Patterns: State your preferred (e.g., MVC, Clean Architecture, simple OOP)
* Framework Conventions: Note relevant framework-specific rules or patterns
* Formatting: Indentation, brace style, and whitespace rules.