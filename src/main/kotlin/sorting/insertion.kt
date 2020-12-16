package sorting


/**
 * In Insertion sort, we divide an array in 2 parts sorted and unsorted. Then in each iteration we take an
 * element from the the unsorted array and place it in the correct position in the sorted array.
 *
 * We start by taking an array [5,1,3,8] and dividing it in two parts. Sorted array [5] and
 * Unsorted array [1,3,8]. Then we iterate over the unsorted array and place them in the correct position.
 *
 * Sorting happens in place.
 *
 * @param arr Array to sort
 */

fun insertionSort(arr: MutableList<Int>) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}