import kotlin.math.abs
import kotlin.math.pow

class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int) = listOf(a, b, c, d).groupingBy { it }.eachCount().let { map ->
        when (map.size) {
            1 -> a * 1111
            2 ->
                if (map.values.contains(2)) map.keys.let { (it.first() + it.last()) * abs(it.first() - it.last()) }
                else map.map { if (it.value == 3) 10 * it.key else it.key }.sum().toDouble().pow(2).toInt()
            3 -> map.filter { it.value == 1 }.map { it.key }.fold(1) { mul, num -> mul * num }
            4 -> map.keys.minOf { it }
            else -> throw Exception("Should not reach here")
        }
    }
}