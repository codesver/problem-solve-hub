import java.util.*;

class Solution {

    boolean[] visited;
    final Queue<Num> nums = new LinkedList<>();

    public int solution(int x, int y, int n) {
        visited = new boolean[y + 1];
        nums.add(new Num(x, 0));
        while (!nums.isEmpty()) {
            Num num = nums.poll();
            if (num.value == y) return num.count;
            calc(num.value + n, y, num.count + 1);
            calc(num.value * 2, y, num.count + 1);
            calc(num.value * 3, y, num.count + 1);
        }
        return -1;
    }

    public void calc(int next, int limit, int count) {
        if (next <= limit && !visited[next]) {
            nums.add(new Num(next, count));
            visited[next] = true;
        }
    }
}

class Num {

    int value, count;

    public Num(int value, int count) {
        this.value = value;
        this.count = count;
    }
}