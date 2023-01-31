class Solution {
    public int solution(int n) {
        int count = 0;
        int step = 1;

        while (true) {
            int temp = n - step * (step - 1) / 2;
            if (temp <= 0)
                break;
            if (temp % step == 0)
                count++;
            step++;
        }

        return count;
    }
}