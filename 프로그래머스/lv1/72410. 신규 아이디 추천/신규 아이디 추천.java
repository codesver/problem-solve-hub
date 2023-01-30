class Solution {
    public String solution(String new_id) {
        String stepOne = new_id.toLowerCase();

        String stepTwo = stepOne.replaceAll("[^a-z-_.\\d]", "");

        String stepThree = stepTwo;
        while (true) {
            int len = stepThree.length();
            stepThree = stepThree.replace("..", ".");
            if (len == stepThree.length()) break;
        }

        String stepFour = stepThree;
        stepFour = stepFour.indexOf(".") == 0 ? stepFour.replaceFirst(".", "") : stepFour;
        stepFour = new StringBuffer(stepFour).reverse().toString();
        stepFour = stepFour.indexOf(".") == 0 ? stepFour.replaceFirst(".", "") : stepFour;
        stepFour = new StringBuffer(stepFour).reverse().toString();

        String stepFive = stepFour.length() == 0 ? "a" : stepFour;

        String stepSix = stepFive.length() >= 16 ? stepFive.substring(0, 15) : stepFive;
        stepSix = stepSix.charAt(stepSix.length() - 1) == '.' ? stepSix.substring(0, stepSix.length() - 1) : stepSix;

        String stepSeven = stepSix.length() <= 2 ? (stepSix + String.valueOf(stepSix.charAt(stepSix.length() - 1)).repeat(2)).substring(0, 3) : stepSix;

        return stepSeven;
    }
}