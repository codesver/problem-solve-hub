import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public int[] nums;
    public boolean[] primes;
    public boolean[] visited;
    public Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        nums = Arrays.stream(numbers.split("")).sorted(Comparator.reverseOrder()).mapToInt(Integer::parseInt).toArray();
        createPrimes();
        visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            visited[i] = true;
            visit(nums[i]);
            visited[i] = false;
        }
        return set.size();
    }

    public void visit(int num) {
        if (!primes[num]) set.add(num);
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                visit(Integer.parseInt(String.valueOf(num) + nums[i]));
                visited[i] = false;
            }
        }
    }

    public void createPrimes() {
        int max = Integer.parseInt(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining()));
        primes = new boolean[max + 1];
        primes[0] = primes[1] = true;
        for (int i = 2; i <= max; i++)
            if (!primes[i]) for (int j = i + i; j <= max; j += i) primes[j] = true;
    }

    public static void main(String[] args) {
        new Solution().solution("011");
    }
}