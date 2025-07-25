# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a comprehensive competitive programming practice repository containing algorithmic problem solutions from multiple online judges and platforms:

- **algospot**: https://algospot.com
- **baekjoon**: https://www.acmicpc.net (Korean Online Judge) 
- **codility**: https://codility.com
- **codingdojang**: http://codingdojang.com
- **hackerrank**: http://hackerrank.com
- **leetcode**: LeetCode problems
- **programmers**: Korean coding test platform (카카오 etc.)
- **testdome**: TestDome challenges

## Commands

### Build and Development
```bash
# Build all projects
./gradlew build

# Build specific module  
./gradlew :baekjoon:build
./gradlew :programmers:build
./gradlew :leetcode:build

# Clean build artifacts
./gradlew clean

# Run tests
./gradlew test

# Run tests for specific module
./gradlew :programmers:test

# List all available tasks
./gradlew tasks

# Make gradlew executable if needed
chmod +x ./gradlew
```

### Running Individual Solutions
Solutions are structured as standalone Main classes:
```bash
# Compile and run from command line
javac -cp src/main/java src/main/java/p1000/Main.java
java -cp src/main/java p1000.Main

# Or run via IDE (IntelliJ IDEA recommended)
```

## Architecture and Structure

### Multi-Module Gradle Project
- **Root project**: `enjoy-algorithm` with Java 17 compatibility
- **Submodules**: Each platform has its own Gradle submodule
  - `algorithmic-problem-solving-strategies/` - Book-based algorithm problems
  - `algospot/` - Algospot platform solutions
  - `baekjoon/` - Baekjoon Online Judge solutions (largest collection, 600+ problems)
  - `basic/` - Basic algorithm implementations and practice
  - `codility/` - Codility programming challenges
  - `codingdojang/` - Coding Dojang problems with diverse topics
  - `hackerrank/` - HackerRank solutions
  - `leetcode/` - LeetCode problems (newer addition)
  - `mailprogramming/` - Mail programming challenges
  - `programmers/` - Programmers platform (카카오 coding tests, levels 0-4)
  - `programming-contets/` - General contest solutions
  - `testdome/` - TestDome assessment problems

### Solution Organization

#### Baekjoon Solutions (`baekjoon/src/main/java/`)
- Organized by problem number: `p{problem_number}/Main.java`
- Some problems have multiple solutions: `Main.java`, `Main2.java`
- Additional helper classes occasionally present
- Multi-language implementations available:
  - **Java**: `src/main/java/` (primary)
  - **C**: `src/main/c/`
  - **Go**: `src/main/go/`
  - **Python**: `src/main/python/`
  - **Kotlin**: `src/main/kotlin/`
  - **Scala**: `src/main/scala/`
  - **Clojure**: `src/main/clojure/`
  - **Groovy**: `src/main/groovy/`
  - **Haskell**: `src/main/haskell/`

#### Programmers Solutions (`programmers/src/main/java/`)
- Organized by difficulty and topic:
  - `levelZero/`, `levelOne/`, `levelTwo/`, `levelThree/`, `levelFour/` - By difficulty
  - `kakaoBlindRecuitment2018/`, `kakaoBlindRecuitment2019/`, etc. - By contest year
  - `hash/`, `greedy/`, `dbfs/` - By algorithm category
  - `skillChecks/` - Skill assessment problems
  - `challenge/` - Contest challenges from various companies
- Python implementations available in `src/main/python/`

#### CodingDojang Solutions (`codingdojang/src/main/java/`)
- Direct problem files with descriptive names
- Self-contained solutions with problem descriptions
- Wide variety of algorithmic topics

### Dependencies and Libraries
- **Java 17**: Modern Java features (var, switch expressions, records)
- **Lombok**: Boilerplate reduction (commented out in current config)
- **Guava**: Google's core Java libraries
- **JUnit Jupiter**: Testing framework
- **Mockito**: Mocking framework for tests
- **Logback**: Logging framework
- **jOOL**: Functional programming utilities
- **SSJ**: Simulation and statistical utilities

### Code Style and Patterns
- Each solution typically includes:
  - Problem title, URL, and classification as comments
  - Problem difficulty/category information
  - Competitive programming optimized structure
  - Fast I/O using `Scanner`, `BufferedReader`, or custom input readers
- Modern Java features utilized:
  - `var` keyword for type inference
  - Switch expressions with `yield`
  - Stream API operations
  - Lambda expressions and method references
- Package structure follows problem numbering for easy navigation

### Working with Solutions
- Most problems are self-contained in their respective files
- Problem URLs and descriptions in comments provide context
- Test cases typically not included (rely on online judge validation)
- Multiple approaches often implemented (brute force vs optimized)
- Cross-language implementations available for comparison in baekjoon module
- Recent additions include more advanced topics like graph algorithms, dynamic programming, and mathematical problems

### Recent Activity Highlights
- Active development through early 2025 (last commit April 3, 2025)
- Focus on Programmers platform level 2-3 problems
- Algorithm topics: Oil drilling, billiards, perfect crime, puzzle games
- Consistent problem-solving practice with detailed implementations