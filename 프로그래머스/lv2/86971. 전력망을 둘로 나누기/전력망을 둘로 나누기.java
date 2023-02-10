import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    boolean[][] network;

    public int solution(int n, int[][] wires) {
        network = new boolean[n + 1][n + 1];
        for (int[] wire : wires) network[wire[0]][wire[1]] = network[wire[1]][wire[0]] = true;
        return Arrays.stream(wires).mapToInt(this::disconnect).min().orElseThrow();
    }

    private int disconnect(int[] wire) {
        try {
            network[wire[0]][wire[1]] = network[wire[1]][wire[0]] = false;
            return Math.abs(bfs(wire[0]) - bfs(wire[1]));
        } finally {
            network[wire[0]][wire[1]] = network[wire[1]][wire[0]] = true;
        }
    }

    public int bfs(int tower) {
        int count = 0;
        boolean[] visited = new boolean[network.length];
        visited[tower] = true;
        Queue<Integer> towers = new LinkedList<>(Collections.singleton(tower));
        while (!towers.isEmpty()) {
            tower = towers.poll();
            for (int t = 1; t < network.length; t++) {
                if (!visited[t] && network[tower][t]) {
                    visited[t] = true;
                    count++;
                    towers.add(t);
                }
            }
        }
        return count;
    }
}