class Solution {
    fun solution(targets: Array<IntArray>) =
        targets.map { it[0] to it[1] }.sortedBy { it.second }.fold(Pair(0, 0)) { info, pair ->
            if (pair.first < info.first) info
            else Pair(pair.second, info.second + 1)
        }.second
}