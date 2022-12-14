import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static int[][] distance;

    private static void solution() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int userNum = Integer.parseInt(tokenizer.nextToken());
        int relationNum = Integer.parseInt(tokenizer.nextToken());

        initDistance(userNum);
        checkRelation(relationNum);
        floydWarshall(userNum);
        result.append(getMinKelvinBaconUser(userNum));
    }

    private static void initDistance(int userNum) {
        distance = new int[userNum + 1][userNum + 1];
        for (int i = 1; i <= userNum; i++)
            for (int j = 1; j <= userNum; j++)
                distance[i][j] = i == j ? 0 : Integer.MAX_VALUE;
    }

    private static void checkRelation(int relationNum) throws IOException {
        StringTokenizer tokenizer;
        while (relationNum-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int userA = Integer.parseInt(tokenizer.nextToken());
            int userB = Integer.parseInt(tokenizer.nextToken());
            distance[userA][userB] = distance[userB][userA] = 1;
        }
    }

    private static void floydWarshall(int userNum) {
        for (int mid = 1; mid <= userNum; mid++)
            for (int from = 1; from <= userNum; from++)
                for (int to = 1; to <= userNum; to++)
                    if (distance[from][mid] != Integer.MAX_VALUE && distance[mid][to] != Integer.MAX_VALUE)
                        distance[from][to] = Math.min(distance[from][to], distance[from][mid] + distance[mid][to]);
    }

    private static int getMinKelvinBaconUser(int userNum) {
        int minKelvinBacon = Integer.MAX_VALUE;
        int minKelvinBaconUser = -1;
        for (int user = 1; user <= userNum; user++) {
            int kelvinBacon = Arrays.stream(distance[user]).sum();
            if (minKelvinBacon > kelvinBacon) {
                minKelvinBacon = kelvinBacon;
                minKelvinBaconUser = user;
            }
        }
        return minKelvinBaconUser;
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