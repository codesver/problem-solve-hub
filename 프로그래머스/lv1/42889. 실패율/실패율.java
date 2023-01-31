import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] S) {
        return IntStream
                .rangeClosed(1, N)
                .mapToObj(Stage::new)
                .peek(stage -> stage.update(S))
                .sorted(Comparator.comparingDouble(s -> -s.failure))
                .mapToInt(Stage::getNum).toArray();
    }
}

class Stage {

    int num;
    int arrive = 0, trial = 0;
    double failure;

    public Stage(int num) {
        this.num = num;
    }

    public void update(int[] S) {
        for (int s : S) {
            if (s >= num) arrive++;
            if (s == num) trial++;
        }
        calcAvg();
    }

    public void calcAvg() {
        failure = arrive == 0 ? 0 : trial / (double) arrive;
    }

    public int getNum() {
        return num;
    }
}