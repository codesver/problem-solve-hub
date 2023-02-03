import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

class Solution {

    public int solution(int[] A, int[] B) {
        Stack<Integer> divA = create(A);
        Stack<Integer> divB = create(B);

        while (true) {
            int da = divA.isEmpty() ? 0 : divA.peek();
            int db = divB.isEmpty() ? 0 : divB.peek();
            if (da == 0 && db == 0) return 0;
            if (da > db)
                if (check(B, da)) return da;
                else divA.pop();
            else if (da < db)
                if (check(A, db)) return db;
                else divB.pop();
            else {
                divA.pop();
                divB.pop();
            }
        }
    }

    public Stack<Integer> create(int[] N) {
        Stack<Integer> divN = new Stack<>();
        IntStream.rangeClosed(2, Arrays.stream(N).min().orElse(0))
                .filter(div -> {
                    for (int n : N)
                        if (n % div != 0) return false;
                    return true;
                }).forEach(divN::push);
        return divN;
    }

    public boolean check(int[] N, int div) {
        for (int n : N) if (n % div == 0) return false;
        return true;
    }
}