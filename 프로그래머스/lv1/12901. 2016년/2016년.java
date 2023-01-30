import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {
        return String.valueOf(LocalDate.of(2016, a, b).getDayOfWeek()).substring(0, 3);
    }
}