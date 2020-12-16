package search


/**
 * For binary search, we need the array to be sorted (here in ascending order), we begin by checking
 * if [target] is equal to the value at middle of the array, if yes we return the index, if not then we narrow our
 * search to the lower half of array if [target] less than the value at the middle or narrow it down to the upper half
 * if [target] is more than the value at the middle.
 *
 * We do this recursively to narrow the our search area till we find the [target] or till [l] > [r] which implies it is
 * not present in the array
 *
 *
 * @param arr Sorted array to search in
 * @param l Look between this index
 * @param r and this index
 * @param target Value to search for
 * @return Index of value; -1 if not found
 */
fun binarySearch(arr:List<Int>,l:Int,r:Int,target: Int):Int =
        if (l > r)
            -1
        else
            ((l+r)/2).let { mid ->
                when {
                    arr[mid] == target -> mid
                    arr[mid] < target -> binarySearch(arr, mid + 1, r, target)
                    else -> binarySearch(arr, l, mid - 1, target)
                }
            }