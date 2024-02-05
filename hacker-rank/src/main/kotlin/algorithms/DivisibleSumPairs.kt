package algorithms

import java.util.*
import java.util.stream.Stream

class DivisibleSumPairs {

    fun divisibleSumPairs(lengthNumbers: Int, divisibleBy: Int, numbers: Array<Int>): Int {
        var result =  0
        for (i in 0 until lengthNumbers) {
            for (j in i + 1 until lengthNumbers) {
                if ((numbers[i] + numbers[j]) % divisibleBy == 0) {
                    result++
                }
            }
        }
       return result
    }
}