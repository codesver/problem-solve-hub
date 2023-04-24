import kotlin.math.pow

class Solution {
    fun solution(a: Int, b: Int, c: Int): Int =
        (1..pow(a, b, c)).fold(1) { total, pow -> total * powSum(a, b, c, pow) }

    private fun pow(a: Int, b: Int, c: Int): Int =
        if (a == b && b == c) 3 else if (a == b || b == c || c == a) 2 else 1

    private fun powSum(a: Int, b: Int, c: Int, pow: Int): Int =
        (a.toDouble().pow(pow) + b.toDouble().pow(pow) + c.toDouble().pow(pow)).toInt()
}