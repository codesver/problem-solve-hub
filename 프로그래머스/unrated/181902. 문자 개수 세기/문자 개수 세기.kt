class Solution {
    fun solution(string: String) = IntArray(52).apply {
        string.forEach {
            if (it.isUpperCase()) this[it.code - 65]++;
            else this[it.code - 71]++;
        }
    }
}