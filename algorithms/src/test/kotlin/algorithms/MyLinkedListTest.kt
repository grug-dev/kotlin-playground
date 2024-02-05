package algorithms

import data_structures.MyLinkedList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyLinkedListTest {

    @Test
    fun `add() should add a new node to the end of the list`() {
        val list = MyLinkedList()
        list.add(1)
        list.add(2)
        list.add(3)
        assertEquals(3, list.size())
        assertEquals(3, list.search(3)!!.data)
    }

    @Test
    fun `add(position) should add a new node at the specified position`() {
        val list = MyLinkedList()
        list.add(1)
        list.add(2)
        list.add(3, 1)
        list.add(4, 2)
        list.add(5, 3)
        assertEquals(5, list.size())
        assertEquals(4, list.search(4)!!.data)
        assertEquals(5, list.search(5)!!.data)
    }

    @Test
    fun `remove() should remove a node from the list`() {
        val list = MyLinkedList()
        list.add(1)
        list.add(2)
        list.add(3)
        list.remove(2)
        assertEquals(2, list.size())
        assertNull(list.search(2))
    }

    @Test
    fun `remove(position) should remove a node at the specified position`() {
        val list = MyLinkedList()
        list.add(1)
        list.add(2)
        list.add(3)
        list.remove(1)
        assertEquals(2, list.size())
        assertEquals(3, list.search(3)!!.data)
    }

    @Test
    fun `search() should return the node with the specified data`() {
        val list = MyLinkedList()
        list.add(1)
        list.add(2)
        list.add(3)
        val node = list.search(2)
        assertNotNull(node)
        assertEquals(2, node!!.data)
    }

    @Test
    fun `size() should return the number of nodes in the list`() {
        val list = MyLinkedList()
        list.add(1)
        list.add(2)
        list.add(3)
        assertEquals(3, list.size())
    }
}