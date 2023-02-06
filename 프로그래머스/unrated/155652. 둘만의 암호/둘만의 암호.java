import java.util.stream.Collectors;

class Solution {
    public String solution(String s, String skip, int index) {
        return s.chars().mapToObj(ch -> {
            for (int i = 0; i < index; i++)
                do {
                    if (ch == 122) ch = 97;
                    else ch++;
                } while (skip.contains(Character.toString(ch)));
            return Character.toString(ch);
        }).collect(Collectors.joining());
    }
}