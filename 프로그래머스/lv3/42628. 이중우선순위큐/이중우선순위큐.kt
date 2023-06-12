import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val max = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
        val min = PriorityQueue<Int>()
        operations.forEach { operation ->
            when (operation) {
                "D 1" -> if (max.isNotEmpty()) min.remove(max.poll())
                "D -1" -> if (min.isNotEmpty()) max.remove(min.poll())
                else -> {
                    val data = operation.substring(2).toInt()
                    max.offer(data)
                    min.offer(data)
                }
            }
        }
        return if (max.isNotEmpty()) intArrayOf(max.peek(), min.peek()) else intArrayOf(0, 0)
    }
}