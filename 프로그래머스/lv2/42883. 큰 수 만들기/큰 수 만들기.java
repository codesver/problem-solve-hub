class Solution {
    public String solution(String number, int k) {
        String[] info = {number, ""};
        int S = number.length() - k;
        for (int s = S; s > 0; s--) {
            int max = -1, idx = 0, L = info[0].length() - s ;
            if (L == 0) return info[1] + info[0];
            for (int d = 0; d <= L; d++) {
                int digit = Character.getNumericValue(info[0].charAt(d));
                if (max < digit) {
                    max = digit;
                    idx = d;
                }
                if (max == 9) break;
            }
            info[0] = info[0].substring(idx + 1);
            info[1] += max;
        }
        return info[1];
    }
}