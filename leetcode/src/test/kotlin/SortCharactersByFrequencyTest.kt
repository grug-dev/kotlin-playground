import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SortCharactersByFrequencyTest {

    val solution = SortCharactersByFrequency()

    @Test
    fun test1() {
        assertEquals("eetr", solution.frequencySort("tree"))
    }
}
