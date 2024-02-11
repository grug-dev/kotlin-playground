package algorithms.sorting

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SortingAlgorithmListTest {
    companion object {

        val RANDOM_FROM_1_TO_10 = randomList(10)
        val SORTED_FROM_1_TO_10 = generateList(10)

        val _100K = 100000
        val RANDOM_FROM_1_TO_100K = randomList(_100K)
        val SORTED_FROM_1_TO_100K = generateList(_100K)

        fun getAlgorithmSort(algorithmType: ESortingAlgorithmType): Sortable<List<Int>> {
            return when (algorithmType) {
                ESortingAlgorithmType.INSERTION_SORT -> return InsertionSort()
                ESortingAlgorithmType.SELECTION_SORT -> return SelectionSort()
                else -> throw IllegalArgumentException("Type not defined")
            }

        }

        fun randomList(n: Int): List<Int> {
            val randomNumbers = mutableListOf<Int>()
            val possibleNumbers = (1..n).toMutableList()

            while (randomNumbers.size < n) {
                val randomIndex = (0 until possibleNumbers.size).random()
                val randomNumber = possibleNumbers.removeAt(randomIndex)
                randomNumbers.add(randomNumber)
            }

            return randomNumbers.toList() // Ensure immutability
        }

        fun generateList(n: Int): List<Int> {
            return (1..n).toList()
        }
    }

    @Test
    fun From1To10SelectionSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.SELECTION_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_10)
        assertEquals(SORTED_FROM_1_TO_10, sortedList)
    }

    @Test
    fun From1To10InsertionSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.INSERTION_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_10)
        assertEquals(SORTED_FROM_1_TO_10, sortedList)
    }

    @Test
    fun From1To100KSelectionSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.SELECTION_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_100K)
        assertEquals(SORTED_FROM_1_TO_100K, sortedList)
    }

    @Test
    fun From1To100KInsertionSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.INSERTION_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_100K)
        assertEquals(SORTED_FROM_1_TO_100K, sortedList)
    }

}