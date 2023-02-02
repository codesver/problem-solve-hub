import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int storey) {
        Stack<Integer> nums = new Stack<>();
        Arrays.stream(("0" + storey).split(""))
                .mapToInt(Integer::parseInt)
                .forEach(nums::push);

        int count = 0;
        while (!nums.isEmpty()) {
            int num = nums.pop();
            if (num == 5 && nums.peek() >= 5 || num > 5) {
                count += 10 - num;
                nums.push(nums.pop() + 1);
            } else count += num;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(555));
    }
}