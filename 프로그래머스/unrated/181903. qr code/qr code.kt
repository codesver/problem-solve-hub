class Solution {
    fun solution(q: Int, r: Int, code: String) =
        (r until code.length step q).joinToString("") { code[it].toString() }
}