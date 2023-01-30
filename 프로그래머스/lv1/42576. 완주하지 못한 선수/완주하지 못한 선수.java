import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> map = new HashMap<>();
        for (String completion : completions)
            if (map.containsKey(completion)) map.put(completion, map.get(completion) + 1);
            else map.put(completion, 1);

        String failed = "";
        for (String participant : participants) {
            if (!map.containsKey(participant)) {
                failed = participant;
                break;
            } else if (map.get(participant) != 0) {
                map.put(participant, map.get(participant) - 1);
            }
            else{
                failed = participant;
                break;
            }
        }
        return failed;
    }
}