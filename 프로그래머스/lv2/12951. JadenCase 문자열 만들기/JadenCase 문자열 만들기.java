class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        String[] strs = s.split(" ");

        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            if (str.equals(""))
                builder.append(" ");
            else if (str.matches("\\d.*"))
                builder.append(str).append(" ");
            else
                builder.append((char) (str.charAt(0) - 32)).append(str.substring(1)).append(" ");
        }

        return builder.substring(0, last == ' ' ? builder.length() : builder.length() - 1);
    }
}