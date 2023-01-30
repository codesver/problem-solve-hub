class Solution {
    public String solution(String s) {
        String lower = s.toLowerCase();
        String upper = s.toUpperCase();

        int index = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append(index % 2 == 0 ? upper.charAt(i) : lower.charAt(i));
            index++;            
            if (s.charAt(i) == ' ') index = 0;
        }
        
        return builder.toString();
    }
}