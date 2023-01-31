class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int changeCount = 0;

        while (!s.equals("1")) {
            zeroCount += s.length() - (s = s.replace("0", "")).length();
            s = Integer.toBinaryString(s.length());
            changeCount++;
        }

        return new int[]{changeCount, zeroCount};
    }
}