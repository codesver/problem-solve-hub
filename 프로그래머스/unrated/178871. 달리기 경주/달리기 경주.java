import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> state = IntStream.range(0, players.length).boxed()
            .collect(Collectors.toMap(g -> players[g], g -> g));
        for (String call : callings) {
            String postPlayer = goThrough(players, state.get(call));
            state.merge(call, -1, Integer::sum);
            state.merge(postPlayer, 1, Integer::sum);
        }
        return players;
    }
    
    private String goThrough(String[] players, int grade) {
        String player = players[grade - 1];
        players[grade - 1] = players[grade];
        players[grade] = player;
        return player;
    }
}