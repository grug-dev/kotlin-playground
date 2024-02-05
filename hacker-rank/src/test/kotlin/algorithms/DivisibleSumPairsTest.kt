package algorithms

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DivisibleSumPairsTest {

    @Test
    fun initialTest() {
        val result = DivisibleSumPairs().divisibleSumPairs(6, 3, arrayOf(1, 3, 2, 6, 1, 2))
        val expected = 5
        assertEquals(expected, result)
    }

    @Test
    fun defaultCase() {
        val result = DivisibleSumPairs().divisibleSumPairs(6, 5, arrayOf(1, 2,3,4,5,6))
        val expected = 3
        assertEquals(expected, result)
    }
}