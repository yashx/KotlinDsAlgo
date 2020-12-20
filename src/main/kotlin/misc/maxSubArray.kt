package misc

/**
 * Class that represents a maximum sub array inside an array.
 *
 * Maybe Not the best way to store this information (arrays will work too) but I like to do it like this.
 *
 * @property startIndex Starting Index of sub Array
 * @property endIndex End Index of sub Array
 * @property sum Sum of sub Array
 */
data class MaxSubArray(val startIndex: Int, val endIndex: Int, val sum: Int)

/**
 * Max sub Array or Largest Sum Contiguous Subarray solved using Divide and Conquer.
 *
 * It works by diving the array in 2 parts (say left and right). Then finds the [MaxSubArray] in left
 * sub array, right sub array and a [MaxSubArray] across left and right.
 *
 * Then it check which of these 3 Sub Arrays is the largest and returns that,
 *
 * Complexity Theta(n log(n))
 *
 * @param arr
 * @param l
 * @param r
 * @return
 */
fun maxSubArrayDnC(arr: List<Int>, l: Int, r: Int): MaxSubArray {
    if (l == r)
        return MaxSubArray(l, l, arr[l])
    val mid = (l + r) / 2
    return maxOf(
            maxSubArrayDnC(arr, l, mid),
            maxSubArrayDnC(arr, mid + 1, r),
            maxSubArrayCrossing(arr, l, mid, r)
    ) { o1, o2 ->
        o1.sum.compareTo(o2.sum)
    }
}

/**
 * Finds max sub Array across the [mid] point.
 *
 * On the left, from [mid] it walks towards [l] and finds the index i, l <= i <= mid, such that arr`[ i..mid]` is max
 *
 * And on the right, from [mid] it walks towards [r] and finds the index j, mid+1 <= j <= r, such that arr`[mid+1..j]` is max
 *
 * Then it returns [MaxSubArray] representing arr`[ i..j]`
 *
 * @param arr
 * @param l
 * @param mid
 * @param r
 * @return [MaxSubArray] across [mid]
 */
fun maxSubArrayCrossing(arr: List<Int>, l: Int, mid: Int, r: Int): MaxSubArray {
    var maxL = mid
    var sumL = arr[mid]
    var maxSumL = sumL
    for (i in (mid - 1) downTo l) {
        sumL += arr[i]
        if (sumL > maxSumL) {
            maxL = i
            maxSumL = sumL
        }
    }

    var maxR = mid + 1
    var sumR = arr[mid + 1]
    var maxSumR = sumR
    for (i in (mid + 2)..r) {
        sumR += arr[i]
        if (sumR > maxSumR) {
            maxR = i
            maxSumR = sumR
        }
    }
    return MaxSubArray(maxL, maxR, maxSumL + maxSumR)
}