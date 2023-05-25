public class Solution {
    public int solution(int n) {
        int battery = 1;
        while (n != 1) {
            if (n % 2 == 0) n /= 2;
            else {
                battery++;
                n--;
            }
        }
        return battery;
    }
}