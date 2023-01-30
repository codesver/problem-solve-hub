class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();
        int left = 10;
        int right = 12;

        for (int number : numbers) {
            number = number == 0 ? 11 : number;

            if (number % 3 == 1) {
                result.append("L");
                left = number;
            } else if (number % 3 == 0) {
                result.append("R");
                right = number;
            } else {
                int l = left % 3 == 1 ? Math.abs(number - 1 - left) / 3 + 1 : Math.abs(number - left) / 3;
                int r = right % 3 == 0 ? Math.abs(number + 1 - right) / 3 + 1 : Math.abs(number - right) / 3;

                if (l == r) {
                    if (hand.equals("right")) {
                        right = number;
                        result.append("R");
                    } else {
                        left = number;
                        result.append("L");
                    }
                } else {
                    if (l < r) {
                        left = number;
                        result.append("L");
                    } else {
                        right = number;
                        result.append("R");
                    }
                }
            }
        }

        return result.toString();
    }
}