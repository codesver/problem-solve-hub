import java.util.Stack

class Solution {
    fun solution(arr: IntArray, flag: BooleanArray) = Stack<Int>().apply {
        arr.forEachIndexed { idx, num ->
            if (flag[idx]) repeat(num * 2) { push(num) }
            else repeat(num) { pop() }
        }
    }.toIntArray()
}