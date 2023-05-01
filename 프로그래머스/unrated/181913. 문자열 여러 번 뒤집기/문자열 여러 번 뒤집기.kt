class Solution {
    fun solution(string: String, queries: Array<IntArray>) = queries.fold(string) { str, (start, end) ->
        str.replaceRange(start, end + 1, str.slice(start..end).reversed())
    }
}