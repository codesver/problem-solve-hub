class Solution {
    public int solution(int n) {
        boolean[] arr = new boolean[n + 1];
        int count = 0;

        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                count++;
                for (int j = i * 2; j < arr.length; j += i)
                    arr[j] = true;
            }
        }
        return count;
    }
}