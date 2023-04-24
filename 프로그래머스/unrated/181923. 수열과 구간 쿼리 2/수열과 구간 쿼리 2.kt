class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray = queries.map { query ->
        (query[0]..query[1]).filter { arr[it] > query[2] }.minOfOrNull { arr[it] } ?: -1
    }.toIntArray()
}