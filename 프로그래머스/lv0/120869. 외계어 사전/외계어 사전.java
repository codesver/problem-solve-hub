class Solution {
    public int solution(String[] spell, String[] dics) {
        Loop:
        for (String dic : dics) {
            if (dic.length() == spell.length) {
                for (String ch : spell) {
                    if (!dic.contains(ch)) continue Loop;
                }
                return 1;
            }
        }
        return 2;
    }
}