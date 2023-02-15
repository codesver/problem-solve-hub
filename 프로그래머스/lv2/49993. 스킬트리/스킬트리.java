import java.util.Arrays;

class Solution {
    public int solution(String skill, String[] skillTrees) {
        return (int) Arrays.stream(skillTrees).filter(tree -> {
            int i = 0;
            for (char c : tree.toCharArray()) {
                int s = skill.indexOf(c);
                if (s == i) i++;
                else if (s != -1) return false;
            }
            return true;
        }).count();
    }
}