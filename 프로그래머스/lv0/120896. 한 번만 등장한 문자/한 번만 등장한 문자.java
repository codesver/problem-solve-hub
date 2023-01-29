import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<String> chars = Arrays.stream(s.split("")).collect(Collectors.toList());
        return chars.stream()
                .filter(ch -> Collections.frequency(chars, ch) == 1)
                .sorted()
                .collect(Collectors.joining());
    }
}