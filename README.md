# kotlin-playground

[![CI](https://github.com/grug-dev/kotlin-playground/actions/workflows/ci.yml/badge.svg)](https://github.com/grug-dev/kotlin-playground/actions/workflows/ci.yml)

Learning repo: classic sorting algorithms and LeetCode problems in Kotlin, with tests.

## Why

I use this repo to practice Kotlin and algorithm basics. Each solution has a
short note on how it works and its cost. It is not a library.

## Run the tests

Needs JDK 21. The Gradle wrapper downloads Gradle 8.5.

```bash
./gradlew check        # all tests
./gradlew :koverLog    # test coverage
```

## What is inside

| Module | Code | Time | Extra space |
|---|---|---|---|
| `algorithms` | `SelectionSort` | O(n²) | O(n) |
| `algorithms` | `InsertionSort` | O(n²), O(n) if already sorted | O(n) |
| `algorithms` | `MergeSort` | O(n log n) | O(n) |
| `algorithms` | `QuickSort` | O(n log n) average, O(n²) worst | O(n) |
| `leetcode` | `TwoSum.twoSum` | O(n²) | O(1) |
| `leetcode` | `TwoSum.twoSumBetterPerformance` | O(n) | O(n) |
| `leetcode` | `SortCharactersByFrequency` | O(n + k log k), k = distinct characters | O(n) |

All sorts implement `Sortable<List<Int>>`.

## How it is tested

- One parameterized test runs every `Sortable` and compares the result with
  Kotlin's `sorted()`. Inputs: empty, one item, duplicates, all equal values,
  negative numbers, sorted, reversed, and 5,000 random values.
- A new sort only needs a new value in `ESortingAlgorithmType`. The shared test
  then covers it.
- CI runs `./gradlew check` on every push and pull request.

## Decisions and trade-offs

- **Sorts return a new list.** The input list is never changed. This is easier
  to test, but it uses O(n) extra memory.
- **QuickSort uses the last item as pivot and a three-way split** (less, equal,
  greater). The code is short and keeps duplicates. The cost: it builds new lists,
  and sorted input gives the O(n²) worst case.
- **TwoSum returns an empty array when there is no answer.** Both versions use
  the same contract, so they can share one test.

## Limits

- Only `Int` lists are sorted. There are no generic versions yet.
- No benchmarks. The Big-O values above come from the code, not from measures.
