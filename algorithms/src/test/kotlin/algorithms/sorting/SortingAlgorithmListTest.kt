package algorithms.sorting

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SortingAlgorithmListTest {
    companion object {

        val RANDOM_FROM_1_TO_10 = randomList(10)
        val SORTED_FROM_1_TO_10 = generateList(10)

        val _100K = 100000
        val RANDOM_FROM_1_TO_K = randomList(_100K)
        val SORTED_FROM_1_TO_K = generateList(_100K)

        fun getAlgorithmSort(algorithmType: ESortingAlgorithmType): Sortable<List<Int>> {
            return when (algorithmType) {
                ESortingAlgorithmType.INSERTION_SORT -> return InsertionSort()
                ESortingAlgorithmType.SELECTION_SORT -> return SelectionSort()
                ESortingAlgorithmType.MERGE_SORT -> return MergeSort()
                ESortingAlgorithmType.QUICK_SORT -> return QuickSort()
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
    fun From1ToKSelectionSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.SELECTION_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_K)
        assertEquals(SORTED_FROM_1_TO_K, sortedList)
    }

    @Test
    fun From1ToKInsertionSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.INSERTION_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_K)
        assertEquals(SORTED_FROM_1_TO_K, sortedList)
    }

    @Test
    fun From1To10MergeSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.MERGE_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_10)
        assertEquals(SORTED_FROM_1_TO_10, sortedList)
    }

    @Test
    fun From1ToKMergeSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.MERGE_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_K)
        assertEquals(SORTED_FROM_1_TO_K, sortedList)
    }

    @Test
    fun From1To10QuickSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.QUICK_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_10)
        assertEquals(SORTED_FROM_1_TO_10, sortedList)
    }

    @Test
    fun From1ToKQuickSort() {
        val sortingAlgorithm = getAlgorithmSort(ESortingAlgorithmType.QUICK_SORT)
        val sortedList = sortingAlgorithm.sort(RANDOM_FROM_1_TO_K)
        assertEquals(SORTED_FROM_1_TO_K, sortedList)
    }

}