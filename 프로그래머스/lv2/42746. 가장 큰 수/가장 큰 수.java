import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (nums[0].equals("0")) return "0";
        return String.join("", nums);
    }
}