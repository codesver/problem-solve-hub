class Solution {
    fun solution(arr: IntArray, queries: IntArray) = queries.foldIndexed(arr) { index, array, query ->
        (if (index % 2 == 0) array.slice(0..query) 
        else array.slice(query until array.size)).toIntArray()
    }
}