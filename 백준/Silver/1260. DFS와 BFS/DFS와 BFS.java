import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static boolean[][] graph;
    private static boolean[] visited;

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int vertexNum = Integer.parseInt(tokenizer.nextToken());
        int edgeNum = Integer.parseInt(tokenizer.nextToken());
        int startingVertex = Integer.parseInt(tokenizer.nextToken());

        graph = new boolean[vertexNum + 1][vertexNum + 1];
        visited = new boolean[vertexNum + 1];

        for (int edge = 0; edge < edgeNum; edge++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertexA = Integer.parseInt(tokenizer.nextToken());
            int vertexB = Integer.parseInt(tokenizer.nextToken());
            graph[vertexA][vertexB] = graph[vertexB][vertexA] = true;
        }

        dfs(startingVertex);
        Arrays.fill(visited, false);
        result.append("\n");
        bfs(startingVertex);
    }

    private static void dfs(int vertex) {
        result.append(vertex).append(" ");
        visited[vertex] = true;
        for (int v = 1; v < graph[vertex].length; v++)
            if (!visited[v] && graph[vertex][v])
                dfs(v);
    }

    private static void bfs(int startingVertex) {
        Queue<Integer> queue = new LinkedList<>(Collections.singleton(startingVertex));
        visited[startingVertex] = true;

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            result.append(vertex).append(" ");
            for (int v = 1; v < graph[vertex].length; v++)
                if (!visited[v] && graph[vertex][v]) {
                    visited[v] = true;
                    queue.add(v);
                }
        }
    }

    private static void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        finish();
    }
}