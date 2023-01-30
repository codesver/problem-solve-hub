class Solution {
    public int solution(String s) {
        int count = 0;
        char ch = ' ';
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (x == 0) {
                ch = s.charAt(i);
                x = 1;
            } else if (ch == s.charAt(i)) {
                x++;
            } else if (x == ++y) {
                count++;
                x = y = 0;
            }
        }
        if (x != 0) count++;
        return count;
    }
}