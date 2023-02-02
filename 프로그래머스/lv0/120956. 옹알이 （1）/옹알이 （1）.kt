class Solution {
    fun solution(babbling: Array<String>): Int {
        return babbling.count { value -> value.replace(Regex("aya|ye|woo|ma"), "").isEmpty() }
    }
}