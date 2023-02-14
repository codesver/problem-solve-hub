import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(String s) {
        final Stack<Sub> subs = new Stack<>();
        return s.length() == 1 ? 1 : IntStream.rangeClosed(1, s.length() / 2).map(unit -> {
            subs.clear();
            for (int idx = 0; idx < s.length(); idx += unit) {
                String substring = s.substring(idx, Math.min(idx + unit, s.length()));
                if (!subs.isEmpty() && subs.peek().string.equals(substring)) subs.peek().count++;
                else subs.push(new Sub(substring));
            }
            return subs.stream().map(Sub::toString).collect(Collectors.joining()).length();
        }).min().orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("1"));
    }
}

class Sub {

    String string;
    int count;

    public Sub(String string) {
        this.string = string;
        count = 1;
    }

    @Override
    public String toString() {
        return count == 1 ? string : (count + string);
    }
}