class Solution {
    boolean solution(String s) {
        String string = s.toLowerCase();
        int numP = 0, numY = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'p') numP++;
            else if (string.charAt(i) == 'y') numY++;
        }
        return numP == numY;
    }
}