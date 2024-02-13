package algorithms.sorting

class QuickSort : Sortable<List<Int>> {

    /**
     * 1. Choose a pivot (last element)
     * 2. Move pivot to its correct position. Left side smaller, larger elements on the right  side.
     * 3. Pivot already has its correct position, split the list in two and repeat the process
     * 4. All elements should have their correct positions
     * 1 8 6 2 4 => 1 2 ^ 8 6 => 1 2 ^ 6 8 => 1 2 4 6 8
     */
    override fun sort(inputData: List<Int>): List<Int> {
        val size = inputData.size
        if (size <= 1) {
            return inputData
        }
        val pivot = inputData[size - 1]
        val less = inputData.filter { it < pivot }
        val greater = inputData.filter { it > pivot }

        return sort(less) + listOf(pivot) + sort(greater)
    }


}