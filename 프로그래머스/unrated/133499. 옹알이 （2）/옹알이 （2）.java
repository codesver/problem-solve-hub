import java.util.Arrays;

class Solution {
    public int solution(String[] babbling) {
        String[] pronounces = new String[]{"aya", "ye", "woo", "ma"};
        return (int) Arrays.stream(babbling).filter(babble -> {
            for (String pronounce : pronounces) {
                if (babble.contains(pronounce + pronounce)) return false;
                babble = babble.replaceAll(pronounce, " ");
            }
            return babble.replaceAll(" ", "").equals("");
        }).count();
    }
}