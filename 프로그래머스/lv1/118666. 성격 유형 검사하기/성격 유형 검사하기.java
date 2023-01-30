import java.util.HashMap;

class Solution {
    HashMap<Character, Integer> map = new HashMap<>();

    private void createMap() {
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
    }

    private void calculateMap(String[] surveys, int[] choices) {
        for (int i = 0; i < surveys.length; i++) {
            int score = choices[i] - 4;
            String survey = surveys[i];

            if (score == 0)
                continue;

            char c = survey.charAt(score > 0 ? 1 : 0);
            map.put(c, map.get(c) + Math.abs(score));
            System.out.println(map);
        }
    }

    private String getResult() {
        return String.valueOf(map.get('R') < map.get('T') ? 'T' : 'R') +
                (map.get('C') < map.get('F') ? 'F' : 'C') +
                (map.get('J') < map.get('M') ? 'M' : 'J') +
                (map.get('A') < map.get('N') ? 'N' : 'A');
    }

    public String solution(String[] surveys, int[] choices) {
        createMap();
        calculateMap(surveys, choices);
        return getResult();
    }
}