package leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertTrue

class SortCharactersByFrequencyTest {

    private val solution = SortCharactersByFrequency()

    // The problem allows any order between characters with the same frequency.
    @ParameterizedTest(name = "\"{0}\" sorts to one of {1}")
    @CsvSource(
        "tree, eert|eetr",
        "cccaaa, cccaaa|aaaccc",
        "Aabb, bbAa|bbaA",
        "z, z",
    )
    fun `sorts characters by decreasing frequency`(input: String, validAnswers: String) {
        val result = solution.frequencySort(input)

        assertTrue(result in validAnswers.split("|"), "\"$input\" gave \"$result\"")
    }

    @ParameterizedTest
    @CsvSource("''")
    fun `keeps an empty string empty`(input: String) {
        assertTrue(solution.frequencySort(input).isEmpty())
    }
}
