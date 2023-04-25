import java.util.Stack

class Solution {
    fun solution(arr: IntArray) = Stack<Int>().apply {
        arr.forEach {
            if (empty() || peek() != it) push(it)
            else pop()
        }
    }.ifEmpty { intArrayOf(-1) }
}