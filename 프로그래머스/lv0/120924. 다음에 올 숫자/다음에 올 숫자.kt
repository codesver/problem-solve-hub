class Solution {
    fun solution(common: IntArray): Int {
        return if (2 * common[1] == common[0] + common[2]) common.last() + common[1] - common[0]
        else common.last() * common[1] / common[0]
    }
}