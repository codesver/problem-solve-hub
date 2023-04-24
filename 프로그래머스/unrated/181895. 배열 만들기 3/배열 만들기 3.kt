class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>) =
        arr.slice(intervals[0][0]..intervals[0][1]).plus(arr.slice(intervals[1][0]..intervals[1][1]))
}