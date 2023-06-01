class Solution {
    public String solution(int n, int t, int m, int p) {
        int num = 0;
        StringBuilder builder = new StringBuilder();
        while (builder.length() < t * m) builder.append(Integer.toString(num++, n));
        StringBuilder result = new StringBuilder();
        for (int c = 0; c < t; c++) result.append(builder.charAt(c * m + p - 1));
        return result.toString().toUpperCase();
    }
}