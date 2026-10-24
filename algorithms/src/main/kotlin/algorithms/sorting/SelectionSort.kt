package algorithms.sorting

class SelectionSort : Sortable<List<Int>> {

    override fun sort(inputData: List<Int>): List<Int> {
        val sortedList = inputData.toMutableList()

        for (i in 0 until sortedList.size) {
            var minIndex = i
            for (j in i + 1 until sortedList.size) {
                if (sortedList[j] < sortedList[minIndex]) {
                    minIndex = j
                }
            }
            swap(sortedList, i, minIndex)
        }
        return sortedList
    }

    private fun swap(data: MutableList<Int>, firstIdx: Int, secondIdx: Int) {
        val tmp = data[firstIdx]
        data[firstIdx] = data[secondIdx]
        data[secondIdx] = tmp
    }
}
