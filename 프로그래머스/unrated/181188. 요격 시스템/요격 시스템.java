import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[][] targets) {
        Queue<Missile> missiles = Arrays.stream(targets)
                .map(Missile::new)
                .sorted(Comparator.comparingInt(Missile::getEnd))
                .collect(Collectors.toCollection(LinkedList::new));
        int end = 0;
        int missileNum = 0;
        while (!missiles.isEmpty()) {
            Missile missile = missiles.poll();
            if (missile.getStart() < end) continue;
            missileNum++;
            end = missile.getEnd();
        }
        return missileNum;
    }
}

class Missile {

    private int start, end;

    public Missile(int[] target) {
        start = target[0];
        end = target[1];
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}