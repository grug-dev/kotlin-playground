import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

data class TwoSumTestData(val nums: IntArray, val target: Int, val expected: IntArray)


class TwoSumTest {

    val twoSumSol = TwoSum()

    companion object {
        @JvmStatic
        fun testData(): Stream<Arguments> {
            return Stream.of(
                TwoSumTestData(intArrayOf(20,21,22,2,16, 7, 11, 15), 9, intArrayOf(3,5)),
                TwoSumTestData(intArrayOf(-3,4,3,90), 0, intArrayOf(0,2)),
                TwoSumTestData(intArrayOf(-1,-2,-3,-4,-5), -8, intArrayOf(2,4)),
                TwoSumTestData(intArrayOf(3, 100,1000, 2, 4), 6, intArrayOf(3, 4)),
                TwoSumTestData(intArrayOf(3, 3), 6, intArrayOf(0, 1))
            ).map { Arguments.of(it) }
        }
    }


    @ParameterizedTest
    @MethodSource("testData")
    fun testTwoSum(data: TwoSumTestData) {
        val actual = twoSumSol.twoSum(data.nums, data.target)
        assertArrayEquals(data.expected, actual)
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun testTwoSumPerformance(data: TwoSumTestData) {
        val actual = twoSumSol.twoSumBetterPerformance(data.nums, data.target)
        assertArrayEquals(data.expected, actual)
    }

}