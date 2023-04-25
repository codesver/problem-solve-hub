class Solution {
    fun solution(order: Array<String>) = order.sumOf { (if ("latte" in it) 5000 else 4500) as Int }
}