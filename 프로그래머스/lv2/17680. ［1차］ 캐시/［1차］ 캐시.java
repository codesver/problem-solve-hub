import java.util.*;

public class Solution {

    public int solution(int cacheSize, String[] cities) {
        Memory memory = new Memory(cacheSize);
        return Arrays.stream(cities)
                .map(String::toLowerCase)
                .mapToInt(memory::search).sum();
    }
}

class Memory {

    private final int limitSize;
    private final Set<String> cache = new HashSet<>();
    private final List<String> cities = new LinkedList<>();

    public Memory(int limitSize) {
        this.limitSize = limitSize;
    }

    public int search(String city) {
        if (cache.contains(city)) {
            cities.remove(city);
            cities.add(city);
            return 1;
        }
        cache.add(city);
        cities.add(city);
        if (cache.size() > limitSize) cache.remove(cities.remove(0));
        return 5;
    }
}