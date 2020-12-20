import misc.maxSubArrayDnC

fun main(args: Array<String>) {

    val len = 10
    val arr = getRandomMutableIntList(6, len)

////////////////////////////// SEARCHING ///////////////////////////////////////////////////////////////////

////// Linear Search
//    print(linearSearch(arr,arr[len-1]))

////// Binary Search
//    val sortedArr = arr.sorted()
//    print(binarySearch(sortedArr,0,sortedArr.size-1,sortedArr[sortedArr.size-1]))

////////////////////////////// SORTING ///////////////////////////////////////////////////////////////////

////// Bubble Sort
//    println(arr)
//    bubbleSort(arr)
//    println(arr)

////// Bubble Sort Alternative Implementation
//    println(arr)
//    bubbleSortAlternative(arr)
//    println(arr)

////// Insertion Sort
//    println(arr)
//    insertionSort(arr)
//    println(arr)

////// Merge Sort
//    println(arr)
//    mergeSort(arr,0,arr.size-1)
//    println(arr)

////// Merge Sort With Inversions
//    println(arr)
//    println("Inversions: ${mergeSortWithInversion(arr,0,arr.size-1)}")
//    println(arr)

////// Quick Sort
//    println(arr)
//    quickSort(arr,0,arr.size-1)
//    println(arr)

///////////////////////////////////// MISC ////////////////////////////////////

///// Max Sub Array
    val a = listOf(-2, -3, 4, -1, -2, 1, 5, -3)
    val maxSubArray = maxSubArrayDnC(a, 0, a.size - 1)
    println("Max sum: ${maxSubArray.sum} from ${maxSubArray.startIndex} to ${maxSubArray.endIndex} index")
}