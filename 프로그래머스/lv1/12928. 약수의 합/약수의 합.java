class Solution {
    public int solution(int n) {
        int sum = 0;
        
        if (n != 0) {
            double sqrt = Math.sqrt(n);
            for (int i = 1; i < sqrt; i++)
                sum += n % i == 0 ? n / i + i : 0;
            sum += Math.pow((int) sqrt, 2) == n ? Math.sqrt(n) : 0;
        }
        
        return sum;
    }
}