class Solution {
    fun solution(string: String, n: Int): String = StringBuilder(string).reverse().substring(0, n).reversed()
}