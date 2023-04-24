class Solution {
    fun solution(names: Array<String>) = (names.indices step 5).map { names[it] }
}