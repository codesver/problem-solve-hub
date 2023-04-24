class Solution {
    fun solution(x1: Boolean, x2: Boolean, x3: Boolean, x4: Boolean) = x1.or(x2).and(x3.or(x4))
}