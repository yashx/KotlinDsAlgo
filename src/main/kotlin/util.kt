import kotlin.random.Random

fun getRandomMutableIntList(seed:Int, len:Int) =
    with(Random(seed)) {
        MutableList(len){
            nextInt(1,100)
        }
    }

fun MutableList<Int>.swap(firstIndex:Int,secondIndex:Int){
    val temp = this[firstIndex]
    this[firstIndex] = this[secondIndex]
    this[secondIndex] = temp
}