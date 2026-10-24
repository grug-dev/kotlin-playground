package leetcode

/**
 * Both solutions return the two indices, or an empty array when no pair adds up to the target.
 */
class TwoSum {

    /**
     * Traverse Array n*n-1 and compare two values with target
     * If are equals to target, return both indices
     * 1 5 3 40 76 6 7 54 9 15 5    target 10   => [1,11]
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val size = nums.size
        for (i in 0 until size - 1) { // n
            for (j in i + 1 until size) { // n -i
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }

    fun twoSumBetterPerformance(nums: IntArray, target: Int): IntArray {
        val complementMap = mutableMapOf<Int, Int>()
        for ((index, value) in nums.withIndex()) {
            val complementIdx = complementMap[target - value]
            if (complementIdx != null) {
                return intArrayOf(complementIdx, index)
            }
            complementMap[value] = index
        }
        return intArrayOf()
    }
}
