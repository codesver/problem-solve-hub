import java.util.ArrayList;

class Solution {

    private final int[] bs = new int[]{1, 3, 4, 5};
    private final int[] cs = new int[]{3, 1, 2, 4, 5};

    public int[] solution(int[] answers) {
        int a = 1, b = 2, c = 3;
        int ca = 0, cb = 0, cc = 0;

        for (int i = 0; i < answers.length; ) {
            int answer = answers[i];
            ca += a == answer ? 1 : 0;
            cb += b == answer ? 1 : 0;
            cc += c == answer ? 1 : 0;
            i++;
            a = a % 5 + 1;
            b = i % 2 == 0 ? 2 : bs[i % 8 / 2];
            c = cs[i % 10 / 2];
        }

        int max = Math.max(ca, Math.max(cb, cc));
        ArrayList<Integer> list = new ArrayList<>();
        if (ca == max) list.add(1);
        if (cb == max) list.add(2);
        if (cc == max) list.add(3);

        return list.stream().mapToInt(ele -> ele).toArray();
    }
}