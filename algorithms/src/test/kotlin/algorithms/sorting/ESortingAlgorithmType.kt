package algorithms.sorting

enum class ESortingAlgorithmType(val create: () -> Sortable<List<Int>>) {
    SELECTION_SORT(::SelectionSort),
    INSERTION_SORT(::InsertionSort),
    MERGE_SORT(::MergeSort),
    QUICK_SORT(::QuickSort),
    ;
}
