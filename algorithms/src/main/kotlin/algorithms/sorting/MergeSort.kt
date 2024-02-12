package algorithms.sorting

class MergeSort : Sortable<List<Int>> {
    /**
     * 1. Split the list into sublists until reach one or two elements
     * 2. Recursively sort the sublists from depth(n) to depth(n-1)
     * 3. Merge sorted sublists depth(n) & depth(n-1)
     */
    override fun sort(inputData: List<Int>): List<Int> {
        val size = inputData.size
        if (size <= 1) {
            return inputData
        }

        val half = size / 2
        var leftPartition: List<Int> = sort(inputData.subList(0, half))
        var rightPartition: List<Int> = sort(inputData.subList(half, size))
        return merge(leftPartition, rightPartition)
    }


    private fun merge(leftHalf: List<Int>, rightHalf: List<Int>): List<Int> {
        val mergedAndSorted = mutableListOf<Int>()
        var leftIdx = 0
        var rightIdx = 0
        val leftMaxIdx = leftHalf.size
        val rightMaxIdx = rightHalf.size

        while (leftIdx < leftMaxIdx && rightIdx < rightMaxIdx) {
            if (leftHalf[leftIdx] < rightHalf[rightIdx]) {
                mergedAndSorted.add(leftHalf[leftIdx++])
            } else {
                mergedAndSorted.add(rightHalf[rightIdx++])
            }
        }
        if (leftIdx < leftMaxIdx) {
            mergedAndSorted.addAll(leftHalf.subList(leftIdx, leftMaxIdx))
        }
        if (rightIdx < rightMaxIdx) {
            mergedAndSorted.addAll(rightHalf.subList(rightIdx, rightMaxIdx))
        }
        return mergedAndSorted
    }
}