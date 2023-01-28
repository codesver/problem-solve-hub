class Solution {
    public int solution(String s) {
        int sum = 0;
        int pre = 0;
        for (String num : s.split(" ")) {
            if (num.equals("Z")) sum -= pre;
            else {
                int n = Integer.parseInt(num);
                sum += n;
                pre = n;
            }
        }
        return sum;
    }
}