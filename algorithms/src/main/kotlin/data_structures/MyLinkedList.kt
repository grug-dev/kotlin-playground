package data_structures

class Node {
    open lateinit var data : Any
    lateinit var next : Node
}
class MyLinkedList {

    fun add(data: Any){}

    fun add(data: Any, position: Int){}
    fun remove(data: Node){}

    fun remove(position: Int){}
    fun search(data: Any): Node? {
        return null;
    }
    fun size(): Int = 0
}