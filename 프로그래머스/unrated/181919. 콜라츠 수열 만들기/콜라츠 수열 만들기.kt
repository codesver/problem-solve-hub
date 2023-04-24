class Solution {
    fun solution(n: Int): IntArray = mutableListOf<Int>().apply {
        var num = n
        while (num != 1) {
            add(num)
            if (num % 2 == 0) num /= 2
            else num = 3 * num + 1
        }
        add(1)
    }.toIntArray()
}