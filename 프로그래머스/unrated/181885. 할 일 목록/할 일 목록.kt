class Solution {
    fun solution(todos: Array<String>, finished: BooleanArray) = todos.filterIndexed { i, _ -> !finished[i] }
}