import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int n) {
        return my_string.chars()
                .mapToObj(ch -> String.valueOf((char) ch).repeat(n))
                .collect(Collectors.joining());
    }
}