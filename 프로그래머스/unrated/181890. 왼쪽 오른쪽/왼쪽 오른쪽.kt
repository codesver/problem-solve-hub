class Solution {
    fun solution(list: Array<String>) = list.onEachIndexed { idx, s ->
        if (s == "l") return list.copyOfRange(0, idx)
        else if (s == "r") return list.copyOfRange(idx + 1, list.size)
    }.let { emptyArray<String>() }
}