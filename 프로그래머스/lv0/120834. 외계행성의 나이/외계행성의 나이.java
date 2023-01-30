import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int age) {
        return Arrays.stream(String.valueOf(age).split(""))
                .map(num -> String.valueOf((char) (Integer.parseInt(num) + 97)))
                .collect(Collectors.joining());
    }
}