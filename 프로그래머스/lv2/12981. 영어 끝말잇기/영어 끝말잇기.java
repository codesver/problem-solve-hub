import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] count = new int[n];
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        count[0]++;

        for (int i = 1; i < words.length; i++) {
            int num = i % n;
            count[num]++;
            String last = words[i - 1];
            String word = words[i];
            if (set.contains(word) || last.charAt(last.length() - 1) != word.charAt(0))
                return new int[]{num + 1, count[num]};
            set.add(word);
        }
        return new int[]{0, 0};
    }
}