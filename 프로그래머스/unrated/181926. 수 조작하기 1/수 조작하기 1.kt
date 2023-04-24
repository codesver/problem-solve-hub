class Solution {
    fun solution(n: Int, control: String): Int = control.fold(n) { num, ch ->
        num + when (ch) {
            'w' -> 1
            's' -> -1
            'd' -> 10
            'a' -> -10
            else -> throw Exception("Should not reach here")
        }
    }
}