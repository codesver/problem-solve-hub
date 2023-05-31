import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> codeMap = IntStream.rangeClosed(1, 26).boxed()
                .collect(Collectors.toMap(i -> Character.toString(i + 64), i -> i));
        Queue<String> strings = Arrays.stream(msg.split("")).collect(Collectors.toCollection(LinkedList::new));
        List<Integer> codes = new LinkedList<>();
        while (!strings.isEmpty()) {
            String string = strings.poll();
            while (!strings.isEmpty()) {
                String next = strings.peek();
                if (codeMap.containsKey(string + next)) {
                    string = string + strings.poll();
                } else {
                    codeMap.put(string + next, codeMap.size() + 1);
                    break;
                }
            }
            codes.add(codeMap.get(string));
        }
        return codes.stream().mapToInt(Integer::intValue).toArray();
    }
}