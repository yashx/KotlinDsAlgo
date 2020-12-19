package sorting


/**
 * See [mergeSort] to learn about how merge sort works.
 *
 * Now, Inversion is a pair of with index (i,j) where i < j but arr`[i]` > arr`[j]`
 * In `[3,2,1]`, inversions are `[3,2]` `[3,1]` and `[2,1]`
 *
 * @param arr
 * @param l
 * @param r
 * @return Number of inversions in original array
 */
fun mergeSortWithInversion(arr: MutableList<Int>, l: Int, r: Int): Int {
    var inv = 0
    if (l >= r)
        return inv
    val mid = (l + r) / 2
    inv += mergeSortWithInversion(arr, l, mid)
    inv += mergeSortWithInversion(arr, mid + 1, r)
    inv += mergeWithInversion(arr, l, mid, mid + 1, r)
    return inv
}

fun mergeWithInversion(arr: MutableList<Int>, l: Int, ll: Int, r: Int, rr: Int): Int {
    val sortedL = mutableListOf<Int>()

    var i = l
    var j = r

    var inv = 0

    while (i <= ll && j <= rr) {
        if (arr[i] <= arr[j]) {
            sortedL.add(arr[i])
            i++
        } else {
            sortedL.add(arr[j])
            // if arr[i] > arr[j], then arr[i..r] are > arr[j] as those are sorted elements. Therefore there are r-i
            // elements greater than the value at arr[j]. Thus that many inversions
            inv += (r - i)
            j++
        }
    }

    while (i <= ll) {
        sortedL.add(arr[i])
        i++
    }

    while (j <= rr) {
        sortedL.add(arr[j])
        j++
    }

    for ((ind, v) in sortedL.withIndex()) {
        arr[l + ind] = v
    }
    return inv
}