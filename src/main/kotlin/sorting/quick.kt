package sorting

import swap

/**
 * In QuickSort, we select a element as pivot and place it in the correct position in the array
 * with all elements smaller to it on its left and all elements bigger to it on the right.
 *
 * This is done by [partition] function which also returns index where it was placed so that quicksort
 * can be called recursively for both sub arrays on its left and right till all elements are in their correct place.
 *
 * Pivot can be chosen in multiple ways. Here we are picking the last element as pivot but first, median or random
 * will also work.
 *
 * It is a Divide and Conquer algorithm and not the fastest way to sort
 *
 * @param arr Array to sort
 * @param l Sort from this index
 * @param r Sort till this index
 */
fun quickSort(arr: MutableList<Int>, l: Int, r: Int) {
    if (l >= r)
        return
    val pivotIndex = partition(arr, l, r)
    quickSort(arr, l, pivotIndex - 1)
    quickSort(arr, pivotIndex + 1, r)
}

/**
 *
 * @param arr Array to sort
 * @param l Sort from this index
 * @param r Sort till this index
 * @return Index where the pivot was placed
 */
fun partition(arr: MutableList<Int>, l: Int, r: Int): Int {
    val pivot = arr[r]
    var smallIndex = l - 1

    for (i in l until r) {
        if (arr[i] < pivot) {
            smallIndex++
            arr.swap(smallIndex, i)
        }
    }
    arr.swap(smallIndex + 1, r)
    return smallIndex + 1
}