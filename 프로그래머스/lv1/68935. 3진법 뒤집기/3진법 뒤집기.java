class Solution {
    public int solution(int n) {
        String three = "";

        while (true) {
            if (n >= 3) {
                three = n % 3 + three;
                n /= 3;
            } else {
                three = n + three;
                break;
            }
        }

        int sum = 0;
        for (int i = 0; i < three.length();i++)
            sum += Math.pow(3, i) * Integer.parseInt(three.substring(i, i + 1));

        return sum;
    }
}