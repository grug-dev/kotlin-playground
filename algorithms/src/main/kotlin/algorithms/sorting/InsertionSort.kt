package algorithms.sorting

class InsertionSort : Sortable<List<Int>> {
    /**
     * 1. Take 1 element as the sorted section. Think like 2 partions (unsorted/sorted)
     * 2. Compare next element to sorted section to decide where to move it
     * 3. If it is lower, put beginning of the sorted section
     * 4. Repeat and move foward
     * 7 8 5 2 => 7 8 5 2 => 5 7 8 2 => 2 5 7 8
     */
    override fun sort(inputData: List<Int>): List<Int> {
        val size = inputData.size
        val sortedList = inputData.toMutableList()

        for (i in 0 until size - 1) {
            if (sortedList[i] > sortedList[i + 1]) {
                moveToSortedSection(sortedList, i)
            }
        }
        return sortedList
    }

    private fun moveToSortedSection(sortedList: MutableList<Int>, position: Int) {
        for (i in position downTo 0) {
            val insertionIndex = i + 1
            if (sortedList[insertionIndex] < sortedList[i]) {
                val tmp = sortedList[i]
                sortedList[i] = sortedList[insertionIndex]
                sortedList[insertionIndex] = tmp
            }
        }
    }
}