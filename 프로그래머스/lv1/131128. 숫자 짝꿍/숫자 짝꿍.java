class Solution {
    public String solution(String X, String Y) {
        int[] xs = new int[10];
        int[] ys = new int[10];
        X.chars().forEach(ch -> xs[Character.getNumericValue((char) ch)]++);
        Y.chars().forEach(ch -> ys[Character.getNumericValue((char) ch)]++);
        StringBuilder builder = new StringBuilder();
        for (int num = 9; num >= 0; num--) 
            builder.append(String.valueOf(num).repeat(Math.min(xs[num], ys[num])));
        return builder.length() == 0 ? "-1" : builder.charAt(0) == '0' ? "0" : builder.toString();
    }
}