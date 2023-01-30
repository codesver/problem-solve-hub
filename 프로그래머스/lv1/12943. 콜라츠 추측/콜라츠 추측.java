class Solution {

    public int solution(int n) {
        long num = n;
        if (num == 1)
            return 0;

        for (int i = 1; i <= 500; i++) {
            num = num % 2 == 0 ? num / 2 : num * 3 + 1;
            if (num == 1)
                return i;
        }
        return -1;
    }
}