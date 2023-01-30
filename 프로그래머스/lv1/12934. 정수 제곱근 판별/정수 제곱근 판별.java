class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return Math.pow((long) sqrt, 2) == n ? (long) Math.pow(sqrt + 1, 2) : -1;
    }
}