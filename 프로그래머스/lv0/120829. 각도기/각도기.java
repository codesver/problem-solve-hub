class Solution {
    public int solution(int angle) {
        return angle % 90 == 0 ? angle / 90 * 2 : angle / 90 * 2 + 1;
    }
}