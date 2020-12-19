package sorting

import swap

/**
 * A simple but inefficient sorting method that works by repeatedly swapping elements that are out of order.
 *
 * Like bubble float upwards, this algorithms works by "floating" elements to either end of the array depending on the
 * way we are sorting.
 *
 * Here in [bubbleSort] for example, as we are sorting in ascending order. On every i th iteration we float the i th
 * biggest element to right end of the array till we get the sorted array.
 *
 * Similarly in [bubbleSortAlternative] we are also sorting in ascending order but by floating the i th smallest element
 * to the left of the array in every i th iteration.
 *
 * @param arr
 */
fun bubbleSort(arr: MutableList<Int>) {
    for (i in 0 until arr.size) {
        for (j in 0 until (arr.size - i - 1)) {
            if (arr[j] > arr[j + 1])
                arr.swap(j, j + 1)
        }
    }
}

fun bubbleSortAlternative(arr: MutableList<Int>) {
    for (i in 0 until arr.size) {
        for (j in arr.size - 1 downTo 1 + i) {
            if (arr[j] < arr[j - 1])
                arr.swap(j, j - 1)
        }
    }
}