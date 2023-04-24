class Solution {
    fun solution(numbers: IntArray, n: Int) =
        numbers.fold(0) { sum, num -> if (sum > n) return sum else sum + num }
}