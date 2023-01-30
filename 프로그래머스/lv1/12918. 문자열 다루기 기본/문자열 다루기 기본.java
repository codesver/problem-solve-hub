class Solution {

    private boolean checkLength(String str) {
        int length = str.length();
        return length == 4 || length == 6;
    }

    private boolean checkNumber(String str) {
        return str.matches("[0-9]+");
    }

    public boolean solution(String s) {
        return checkLength(s) && checkNumber(s);
    }
}