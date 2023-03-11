import java.util.stream.IntStream;

class Solution {

    int maxDiff = 1;
    int[] result = {-1};

    public int[] solution(int n, int[] info) {
        shoot(info, IntStream.generate(() -> 0).limit(11).toArray(), n, 0);
        return result;
    }

    private void shoot(int[] peach, int[] lion, int arrow, int idx) {
        if (idx == 11) {
            int diff = IntStream.rangeClosed(0, 10).map(i -> lion[i] != 0 ? 10 - i : peach[i] != 0 ? i - 10 : 0).sum();
            if (maxDiff <= diff) {
                int[] lionRes = lion.clone();
                lionRes[10] += arrow;
                if (maxDiff == diff && result.length == 11) lionRes = compareResult(result, lionRes);
                maxDiff = diff;
                result = lionRes;
            }
        } else for (int i = idx; i < peach.length; i++) {
            if (arrow > peach[i]) {
                lion[i] = peach[i] + 1;
                shoot(peach, lion, arrow - peach[i] - 1, i + 1);
                lion[i] = 0;
            } else if (arrow == 0) {
                shoot(peach, lion, arrow, 11);
                break;
            } else shoot(peach, lion, arrow, i + 1);
        }
    }

    private int[] compareResult(int[] lionA, int[] lionB) {
        for (int i = 10; i >= 0; i--)
            if (lionA[i] != lionB[i])
                return lionA[i] > lionB[i] ? lionA : lionB;
        return result;
    }
}