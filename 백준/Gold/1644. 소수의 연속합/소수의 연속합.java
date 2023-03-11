import java.io.*;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        final int NUM = Integer.parseInt(reader.readLine());
        if (NUM == 1) result.append(0);
        else {
            boolean[] isNotPrime = new boolean[NUM + 1];
            int[] primes = IntStream.rangeClosed(2, NUM).filter(num -> {
                if (!isNotPrime[num])
                    for (int n = num + num; n <= NUM; n += num)
                        isNotPrime[n] = true;
                return !isNotPrime[num];
            }).toArray();
            int front = 0, back = 1, sum = primes[0], count = 0;
            while (true) {
                if (sum >= NUM) {
                    if (sum == NUM) count++;
                    if (front + 1 == back) break;
                    sum -= primes[front++];
                } else {
                    if (back == primes.length) break;
                    sum += primes[back++];
                }
            }
            result.append(count);
        }
    }

    private void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}
