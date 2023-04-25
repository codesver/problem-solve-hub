class Solution {
    fun solution(arr: IntArray) = mutableListOf<Int>().apply {
        arr.forEach { num -> repeat(num) { add(num) } }
    }
}