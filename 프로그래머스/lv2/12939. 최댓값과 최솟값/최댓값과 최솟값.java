import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] sort = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        return sort[0] + " " + sort[sort.length - 1];
    }
}