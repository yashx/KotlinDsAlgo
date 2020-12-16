package search

/**
 * In linear search, we start from one end (say left) and compare [target] to all elements one by one
 * till we find a match. If a match is found we return the index and if not we return -1
 *
 * If there are multiple instance, we return index of first occurrence we find.
 *
 * @param arr Array to search in
 * @param target Value to search for
 * @return Index of value; -1 if not found
 */

fun linearSearch(arr:List<Int>, target: Int):Int{
    for ((i,v) in arr.withIndex())
        if (v==target)
            return i
    return -1
}