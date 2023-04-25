class Solution {
    fun solution(arr: IntArray, deleteList: IntArray) = arr.filterNot { deleteList.contains(it) }
}