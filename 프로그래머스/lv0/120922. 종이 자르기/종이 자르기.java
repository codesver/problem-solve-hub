class Solution {
    public int solution(int M, int N) {
        return Math.max(M - 1, N - 1) + Math.min(M - 1 , N - 1) * Math.max(M, N);
    }
}