import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> nums = new ArrayList<>();
        nums.add(arr[0]);

        for (int i = 1; i < arr.length; i++)
            if (!(arr[i] == arr[i - 1]))
                nums.add(arr[i]);

        return nums.stream().mapToInt(i->i).toArray();
    }
}