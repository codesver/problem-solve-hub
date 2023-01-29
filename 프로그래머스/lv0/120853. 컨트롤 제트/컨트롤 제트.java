import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<String> nums = new Stack<>();
        for (String num : s.split(" ")) {
            if (num.equals("Z")) nums.pop();
            else nums.push(num);
        }
        return nums.stream().mapToInt(Integer::parseInt).sum();
    }
}