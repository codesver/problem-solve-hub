class Solution {

    private int[] numbers;
    private int target;
    private int count = 0;

    private void calc(int idx, int sum) {
        if (idx == numbers.length) {
            count += sum == target ? 1 : 0;
        } else {
            calc(idx + 1, sum + numbers[idx]);
            calc(idx + 1, sum - numbers[idx]);
        }
    }

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        calc(0, 0);
        return count;
    }
}