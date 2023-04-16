class Solution {
    fun solution(n: Int, t: Int): Int = (0 until t).fold(n) { total, _ -> total * 2}
}