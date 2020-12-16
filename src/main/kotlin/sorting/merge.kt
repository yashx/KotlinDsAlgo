package sorting

/**
 * In Merge Sort, we divide the array in two parts, sort them and then merge the two sorted parts.
 *
 * In merge sort, we keep dividing the array in two parts recursively till we only have one element in the sub array
 * (as when there is only one element in an array, it is kinda of sorted :| ) , then we start merging them back till we
 * get the sorted array.
 *
 * Sorting is basically done by [merge] function, which takes two sorted arrays and combines them to give a single
 * merged sorted array (It doesn't return anything but sorts them in place). So it takes [5] and [3],
 * and gives [3, 5]. Then it takes [3, 5] and [4, 8], and gives [3, 4, 5, 8] and so on.
 *
 *
 * @param arr Array to sort
 * @param l Sort from this index
 * @param r Sort till this index
 */

fun mergeSort(arr: MutableList<Int>, l: Int, r: Int) {
    if (l >= r)
        return
    val mid = (l + r) / 2
    mergeSort(arr, l, mid)
    mergeSort(arr, mid + 1, r)
    merge(arr, l, mid, mid + 1, r)
}

/**
 *
 * @param arr Array to sort
 * @param l Starting index for first sorted sub array
 * @param ll Ending index for first sorted sub array
 * @param r Starting index for second sorted sub array
 * @param rr Ending index for second sorted sub array
 */
fun merge(arr: MutableList<Int>, l: Int, ll: Int, r: Int, rr: Int) {
    val sorted = mutableListOf<Int>()
    var x = l
    var y = r
    while (x <= ll && y <= rr) {
        if (arr[x] <= arr[y]) {
            sorted.add(arr[x])
            x++
        } else {
            sorted.add(arr[y])
            y++
        }
    }

    while (x <= ll) {
        sorted.add(arr[x])
        x++
    }

    while (y <= rr) {
        sorted.add(arr[y])
        y++
    }

    for ((i, v) in sorted.withIndex()) {
        arr[l + i] = v
    }

}
