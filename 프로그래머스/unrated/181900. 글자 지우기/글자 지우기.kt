class Solution {
    fun solution(string: String, indices: IntArray) = string.filterIndexed { i, _ ->
        indices.contains(i).not()
    }
}