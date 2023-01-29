class Solution {
    public int solution(int n) {
        int num = 0;
        while (n-- > 0) {
            num++;
            while (num % 3 == 0 || String.valueOf(num).contains("3")) num++;
        }
        return num;
    }
}