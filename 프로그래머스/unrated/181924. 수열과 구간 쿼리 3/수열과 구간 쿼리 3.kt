class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray =
        arr.apply { queries.forEach { swap(arr, it[0], it[1]) } }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}