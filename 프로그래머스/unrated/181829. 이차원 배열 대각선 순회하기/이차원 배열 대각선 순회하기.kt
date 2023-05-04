class Solution {
    fun solution(board: Array<IntArray>, k: Int) =
        board.mapIndexed { row, nums -> nums.filterIndexed { col, _ -> row + col <= k }.sum() }.sum()
}