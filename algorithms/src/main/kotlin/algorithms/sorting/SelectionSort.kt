package algorithms.sorting

class SelectionSort : Sortable<List<Int>> {

    override fun sort(dataToSort: List<Int>): List<Int> {
       var sortedList = dataToSort.toMutableList()

        if (dataToSort.isEmpty()) return sortedList;

        for (i in 0 until sortedList.size) {
            var minIndex = i
            for (j in i + 1 until sortedList.size ) {
                val currentVal = sortedList[j]
                val minOfCurrentPos = sortedList[minIndex]
                if ( currentVal < minOfCurrentPos ) {
                    minIndex = j
                }
            }
            swap(sortedList, i, minIndex)
        }
        return sortedList
    }

    fun swap(data: MutableList<Int>, firstIdx: Int, secondIdx: Int) {
        val tmp = data[firstIdx]
        data[firstIdx] = data[secondIdx]
        data[secondIdx] = tmp
    }


}