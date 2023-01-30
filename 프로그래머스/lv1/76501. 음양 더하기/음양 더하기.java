import java.util.Arrays;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        for (int i = 0; i < absolutes.length; i++) absolutes[i] *= signs[i] ? 1 : -1;
        return Arrays.stream(absolutes).sum();
    }
}