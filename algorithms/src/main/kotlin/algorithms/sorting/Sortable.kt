package algorithms.sorting

interface Sortable<T> {
    fun sort(inputData: T): T
}