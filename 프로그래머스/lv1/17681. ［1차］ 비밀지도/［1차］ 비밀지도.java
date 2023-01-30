import java.util.stream.IntStream;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] key = new String[n];

        for (int i = 0; i < n; i++) {
            String res = Integer.toBinaryString(arr1[i] | arr2[i]);
            res = ("0".repeat(n - res.length()) + res);
            res = res.replace('0', ' ').replace('1', '#');
            key[i] = res;
        }

        return key;
    }
}