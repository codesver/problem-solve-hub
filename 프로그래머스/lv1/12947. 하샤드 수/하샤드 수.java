class Solution {
    private int sum = 0;

    public boolean solution(int x) {
        String.valueOf(x).chars().forEach(ele -> sum += ele - '0');
        return x % sum == 0;
    }
}