import kotlin.math.abs

class Solution {
    fun solution(a: Int, b: Int) =
        if (a * b % 2 == 1) a * a + b * b
        else if ((a + b) % 2 == 1) 2 * (a + b)
        else abs(a - b)
}