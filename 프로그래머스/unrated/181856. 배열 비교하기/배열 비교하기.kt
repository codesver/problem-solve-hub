class Solution {
    fun solution(arr1: IntArray, arr2: IntArray) =
        if (arr1.size == arr2.size) arr1.sum().compareTo(arr2.sum())
        else arr1.size.compareTo(arr2.size)
}