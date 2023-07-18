import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String str1, String str2) {
        StringJaccard jaccard = new StringJaccard(str1, str2);
        return (int) (jaccard.similarity() * 65536);
    }
}

class StringJaccard {
    
    private final Map<String, Integer> setA, setB;
    
    public StringJaccard(String stringA, String stringB) {
        setA = createSet(stringA);
        setB = createSet(stringB);
    }
    
    public double similarity() {
        double same = 0, sum = 0;
        
        for (Map.Entry<String, Integer> entry : setA.entrySet()) {
            if (setB.containsKey(entry.getKey())) {
                same += Math.min(entry.getValue(), setB.get(entry.getKey()));
            }
            sum += Math.max(entry.getValue(), setB.getOrDefault(entry.getKey(), 0));
        }
        
        for (Map.Entry<String, Integer> entry : setB.entrySet()) {
            if (!setA.containsKey(entry.getKey())) {
                sum += entry.getValue();
            }
        }
        
        return sum == 0 ? 1 : same / sum;
    }
    
    private Map<String, Integer> createSet(String string) {
        Map<String, Integer> set = new HashMap<>();
        for (int i = 0; i < string.length() - 1; i++) {
            String substring = string.substring(i, i + 2);
            if (substring.matches("[A-Za-z][A-Za-z]")) {
                set.merge(substring.toUpperCase(), 1, Integer::sum);
            }
        }
        System.out.println(set);
        return set;
    }
}