import java.util.Stack;

class Solution {

    public final Stack<Character> line = new Stack<>();
    public final char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public String[] data;
    public int count = 0;

    public int solution(int n, String[] data) {
        this.data = data;
        for (int f = 0; f < 8; f++) {
            line.push(friends[f]);
            lining();
            line.pop();
        }
        return count;
    }

    public void lining() {
        if (line.size() == 8 && check()) count++;
        else for (int f = 0; f < 8; f++) {
            if (!line.contains(friends[f])) {
                line.push(friends[f]);
                lining();
                line.pop();
            }
        }
    }

    public boolean check() {
        for (String datum : data) {
            int diff = Math.abs(line.indexOf(datum.charAt(2)) - line.indexOf(datum.charAt(0))) - 1;
            char op = datum.charAt(3);
            int num = Character.getNumericValue(datum.charAt(4));
            if (op == '=' && diff != num || op == '>' && diff <= num || op == '<' && diff >= num) return false;
        }
        return true;
    }
}