import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet<>(Arrays.asList(phoneBook));
        for (String s : phoneBook)
            for (int end = 0; end < s.length(); end++)
                if (set.contains(s.substring(0, end)))
                    return false;
        return true;
    }
}