import java.util.Stack;

class Solution {

    public int solution(String dartResult) {
        Stack<Integer> nums = new Stack<>() {{
            push(0);
        }};

        dartResult.replaceAll("10", "+").chars().forEach(ch -> {
            if (Character.isDigit(ch)) nums.add(Character.getNumericValue(ch));
            else if (Character.isAlphabetic(ch)) nums.push((int) Math.pow(nums.pop(), ch != 'S' ? ch / 28 : 1));
            else if (ch == '+') nums.add(10);
            else if (ch == '#') nums.add(-nums.pop());
            else if (ch == '*') {
                int top = nums.pop() * 2;
                nums.push(nums.pop() * 2);
                nums.push(top);
            }
        });

        return nums.stream().mapToInt(Integer::intValue).sum();
    }

}