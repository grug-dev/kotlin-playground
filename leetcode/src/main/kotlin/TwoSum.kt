class TwoSum {

    /**
     * Traverse Array n*n-1 and compare two values with target
     * If are equals to target, save both indices to a Set Collection
     * transform intArray
     * 1 5 3 40 76 6 7 54 9 15 5    target 10   => [1,11]
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val size = nums.size
        var result = IntArray(2)
        for (i in 0 until size - 1) { // n
            for (j in i + 1 until size) { // n -i
                if (nums[i] + nums[j] == target) {
                    result[0]=i
                    result[1]=j
                    return result
                }
            }
        }
        return result
    }

    fun twoSumBetterPerformance(nums: IntArray, target: Int): IntArray {
        var complementMap = mutableMapOf<Int,Int>()
        for ( (index,value) in nums.withIndex() ) {
            val complement = target - value
            val idxDiff = complementMap[complement]
            idxDiff?.let {
                return intArrayOf(idxDiff, index)
            }
            complementMap[value] = index
        }
        return intArrayOf()
    }
}