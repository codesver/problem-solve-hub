import java.util.*;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        
        while (true) {
            if (n / 10 == 0) {
                sum += n;
                break;
            } else {
                sum += n % 10;
                n /= 10;
            }
        }
        return sum;
    }
}