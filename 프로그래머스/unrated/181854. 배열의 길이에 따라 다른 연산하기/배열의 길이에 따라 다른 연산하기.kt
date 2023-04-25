class Solution {
    fun solution(arr: IntArray, n: Int) = arr.mapIndexed { index, num ->
        num + if ((arr.size + index) % 2 == 1) n else 0
    }
}