class Solution {
    public String solution(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int type = n % 3;
            if (type == 0) {
                builder.append(4);
                n = n / 3 - 1;
            } else {
                builder.append(type);
                n /= 3;
            }
        }
        return builder.reverse().toString();
    }
}