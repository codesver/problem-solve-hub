import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        return new StringBuilder(Arrays.stream(s.split("")).sorted().collect(Collectors.joining())).reverse().toString();
    }
}