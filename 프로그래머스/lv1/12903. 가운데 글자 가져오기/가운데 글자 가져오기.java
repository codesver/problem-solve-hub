class Solution {
    public String solution(String s) {
        int half = s.length() / 2;
        return s.length() % 2 == 0 ?
                s.substring(half - 1, half + 1) :
                String.valueOf(s.charAt(half));
    }
}