import java.util.stream.IntStream;

class Solution {
    public int solution(String t, String p) {
        return (int) IntStream.rangeClosed(0, t.length() - p.length())
                .filter(i -> Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p))
                .count();
    }
}