import java.util.*

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 */
data class CharacterFrequency(val character: String, val frequency: Long) : Comparable<CharacterFrequency> {
    override fun compareTo(o1: CharacterFrequency): Int {
        return o1.frequency.compareTo(this.frequency)
    }
}

class SortCharactersByFrequency {


    /**
     * 1. Find frequency per character and save it in Map<Character,Long>
     * 2. Use key/values and save them into PriorityQueue
     * 3. Priority Queue should be sorted DESC
     * 4. Concat values from PriorityQueue and build the word descending order
     */
    fun frequencySort(s: String): String {
        return concatCharactersFromQueue(saveCharPerFrequencyToQueue(createCharFrequencyMap(s)))
    }

    private fun createCharFrequencyMap(word: String): Map<Char, Long> {
        var map = mutableMapOf<Char, Long>()
        if (word.isEmpty()) return map

        for (char in word) {
            map[char] = map[char]?.plus(1) ?: 1
        }
        return map
    }

    private fun saveCharPerFrequencyToQueue(frequencyMap: Map<Char, Long>): PriorityQueue<CharacterFrequency> {
        val priorityQueue = PriorityQueue<CharacterFrequency>()
        frequencyMap.forEach { character, frequency ->
            val repeatedCharacter = character.toString().repeat(frequency.toInt())
            priorityQueue.add(CharacterFrequency(repeatedCharacter, frequency))
        }
        return priorityQueue
    }

    private fun concatCharactersFromQueue(queue: PriorityQueue<CharacterFrequency>): String {
        var resultBuilder = StringBuilder()
        while (queue.isNotEmpty()) {
            resultBuilder.append(queue.poll().character)
        }

        return resultBuilder.toString()
    }
}