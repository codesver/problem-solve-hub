class Solution {
    fun solution(numLog: IntArray): String = StringBuilder().apply {
        for (i in 1 until numLog.size) append(
            when (numLog[i] - numLog[i - 1]) {
                1 -> 'w'
                -1 -> 's'
                10 -> 'd'
                -10 -> 'a'
                else -> throw Exception("Should not reach here.")
            }
        )
    }.toString()
}