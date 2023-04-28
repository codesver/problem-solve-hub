class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int) = when (ineq) {
        "<" -> if (eq == "=" && n <= m || eq == "!" && n < m) 1 else 0
        ">" -> if (eq == "=" && n >= m || eq == "!" && n > m) 1 else 0
        else -> throw Exception("Should not reach here")
    }
}