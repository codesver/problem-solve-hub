import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<Integer, Integer> parks = new TreeMap<>();
        Map<Integer, Integer> ins = new HashMap<>();

        for (String record : records) {
            int time = LocalTime.parse(record.substring(0, 5)).get(ChronoField.MINUTE_OF_DAY);
            int car = Integer.parseInt(record.substring(6, 10));
            String type = record.substring(11);
            if (type.equals("IN")) ins.put(car, time);
            else {
                parks.put(car, parks.getOrDefault(car, 0) + (time - ins.get(car)));
                ins.remove(car);
            }
        }

        int end = LocalTime.parse("23:59").get(ChronoField.MINUTE_OF_DAY);
        for (Map.Entry<Integer, Integer> entry : ins.entrySet())
            parks.put(entry.getKey(), parks.getOrDefault(entry.getKey(), 0) + (end - entry.getValue()));

        return parks.values().stream().mapToInt(time -> {
            int sum = fees[1];
            time -= fees[0];
            if (time > 0) {
                sum += time / fees[2] * fees[3];
                if (time % fees[2] != 0) sum += fees[3];
            }
            return sum;
        }).toArray();
    }
}