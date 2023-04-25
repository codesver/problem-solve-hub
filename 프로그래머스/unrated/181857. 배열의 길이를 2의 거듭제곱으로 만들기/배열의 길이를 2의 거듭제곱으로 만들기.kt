class Solution {
    fun solution(arr: IntArray) = arr.toMutableList().apply {
        val binary = size.toString(2)
        if (binary.matches(Regex("10*")).not()) 
            repeat(("1" + "0".repeat(binary.length)).toInt(2) - size) { add(0) }
    }
}