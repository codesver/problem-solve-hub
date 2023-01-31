import java.util.stream.Collectors;

class Solution {
    
    public String solution(String s, int n) {
        return s.chars().mapToObj(ch -> convert(ch, n)).collect(Collectors.joining());
    }

    public String convert(int ch, int n) {
        if (ch == ' ') return " ";
        int num = Character.isUpperCase(ch) ? 65 : 97;
        return Character.toString(((ch - num) + n) % 26 + num);
    }
}