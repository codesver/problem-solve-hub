import java.util.Arrays;

class Solution {
    public int solution(int[] ingredient) {
        StringBuilder builder = new StringBuilder();
        return (int) Arrays.stream(ingredient).filter(i -> {
            builder.append(i);
            if (builder.length() >= 4
                    && builder.substring(builder.length() - 4, builder.length()).equals("1231")) {
                builder.delete(builder.length() - 4, builder.length());
                return true;
            } else return false;
        }).count();
    }
}