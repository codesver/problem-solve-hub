class Solution {
    fun solution(nums: IntArray) = nums.sumOf { num ->
        generateSequence(num) {
            if (it == 1) null
            else if (it % 2 == 0) it / 2
            else (it - 1) / 2
        }.count() - 1
    }
}