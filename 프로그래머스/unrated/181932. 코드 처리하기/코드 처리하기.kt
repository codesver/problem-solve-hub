class Solution {

    private var mode = 0

    fun solution(code: String): String = code.filterIndexed { idx, ch ->
        if (ch == '1') mode = (mode + 1) % 2
        ch != '1' && mode == idx % 2
    }.ifEmpty { "EMPTY" }
}