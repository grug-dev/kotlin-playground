package algorithms.sorting

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SelectionSortTest {
    companion object {

        val RANDOM_FROM_1_TO_10 = randomList(10)
        val SORTED_FROM_1_TO_10 = generateList(10)

        fun <T> provideSelectionSort(): SelectionSort {
            return SelectionSort()
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
    fun testListNumbersSorting() {
        val selectionSort = provideSelectionSort<List<Int>>()
        val sortedList = selectionSort.sort(RANDOM_FROM_1_TO_10)
        assertEquals(sortedList, SORTED_FROM_1_TO_10)
    }

}