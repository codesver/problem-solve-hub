import java.util.Stack

class Solution {
    fun solution(arr: IntArray): IntArray = Stack<Int>().apply {
        arr.forEach {
            while (isNotEmpty() && peek() >= it) pop()
            push(it)
        }
    }.toIntArray()
}