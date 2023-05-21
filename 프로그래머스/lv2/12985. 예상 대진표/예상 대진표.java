class Solution {
    public int solution(int n, int a, int b) {
        for(int round = 1; round <= Math.log(n) / Math.log(2); round++) {
            if (Math.abs(a - b) == 1 && Math.min(a, b) % 2 == 1) return round;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        throw new RuntimeException("The game is over");
    }
}