class Solution {
    fun solution(ranks: IntArray, attendance: BooleanArray) =
        ranks.mapIndexed { index, rank -> Pair(index, rank) }
            .filter { attendance[it.first] }
            .sortedBy { it.second }
            .let { (a, b, c) -> 10000 * a.first + 100 * b.first + c.first }
}