class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>) = arr.apply {
        queries.forEach { (s, e) -> (s..e).forEach { arr[it]++ } }
    }
}