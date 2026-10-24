package algorithms.sorting

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.random.Random
import kotlin.test.assertEquals

/**
 * Every Sortable must give the same result as the standard library sort:
 * same elements, ascending order, duplicates kept.
 * A new algorithm only needs a new ESortingAlgorithmType value.
 */
class SortingAlgorithmListTest {

    companion object {
        // O(n^2) sorts are part of the set, so keep the big input small enough to stay fast.
        private const val BIG_SIZE = 5_000

        private val inputs: Map<String, List<Int>> = mapOf(
            "an empty list" to emptyList(),
            "one item" to listOf(7),
            "random values" to listOf(1, 8, 6, 2, 4),
            "duplicates" to listOf(3, 1, 3, 2, 1, 3),
            "all equal values" to listOf(5, 5, 5, 5),
            "negative numbers" to listOf(0, -5, 3, -1, -5),
            "a sorted list" to (1..20).toList(),
            "a reversed list" to (20 downTo 1).toList(),
            "$BIG_SIZE random values" to Random(42).let { r -> List(BIG_SIZE) { r.nextInt(-1_000, 1_000) } },
        )

        @JvmStatic
        fun cases(): Stream<Arguments> =
            ESortingAlgorithmType.entries.flatMap { type ->
                inputs.map { (name, input) -> Arguments.of(type, name, input) }
            }.stream()
    }

    @ParameterizedTest(name = "{0} sorts {1}")
    @MethodSource("cases")
    fun `sorts like the standard library`(type: ESortingAlgorithmType, name: String, input: List<Int>) {
        val sorted = type.create().sort(input)

        assertEquals(input.sorted(), sorted, "$type failed on $name")
    }
}
