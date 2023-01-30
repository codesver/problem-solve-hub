import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private static HashMap<String, Set<String>> reported = new HashMap<>();
    private static HashMap<String, Integer> index = new HashMap<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            reported.put(id, new HashSet<>());
            index.put(id, i);
        }

        for (String r : report) reported.get(r.split(" ")[1]).add(r.split(" ")[0]);

        int[] sol = new int[id_list.length];

        for (int i = 0; i < reported.size(); i++) {
            Set<String> set = reported.get(id_list[i]);
            if (set.size() >= k) for (String s : set) sol[index.get(s)]++;
        }
        
        return sol;
    }
}