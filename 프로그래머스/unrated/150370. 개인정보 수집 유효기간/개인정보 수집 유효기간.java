import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<Character, Integer> map = new HashMap<>();
        for (String term : terms) map.put(term.charAt(0), Integer.parseInt(term.substring(2)));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate now = LocalDate.parse(today, formatter);

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= privacies.length; i++) {
            String info = privacies[i - 1];
            LocalDate expire = LocalDate.parse(info.substring(0, 10), formatter)
                    .plusMonths(map.get(info.charAt(11)))
                    .minusDays(1);
            if (expire.isBefore(now)) nums.add(i);
        }
        return nums.stream().mapToInt(n -> n).toArray();
    }
}