import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 2];
        Arrays.fill(clothes, 1);
        Arrays.stream(reserve).forEach(std -> clothes[std] = 2);
        Arrays.stream(lost).forEach(std -> clothes[std]--);
        
        return IntStream.rangeClosed(1, n).map(std ->
                clothes[std] == 2 ?
                        clothes[std - 1] == 0 ?
                                2 :
                                clothes[std + 1] == 0 ?
                                        clothes[std + 1] = 1 :
                                        1 :
                        clothes[std]
        ).sum();
    }
}