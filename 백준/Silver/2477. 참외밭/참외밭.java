import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        int num = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int dir = Integer.parseInt(tokenizer.nextToken());
        int dis = Integer.parseInt(tokenizer.nextToken());
        Farm farm = new Farm(num, dir, dis);
        for (int i = 0; i < 5; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            dir = Integer.parseInt(tokenizer.nextToken());
            dis = Integer.parseInt(tokenizer.nextToken());
            farm.addData(dir, dis);
        }
        result.append(farm.count());
    }

    static class Farm {

        int maxW, maxH;
        int firstDis, lastDis, lastDir;
        int empty;

        final int NUM;
        final int[] last = new int[5];

        public Farm(int NUM, int dir, int dis) {
            this.NUM = NUM;
            last[1] = 4;
            last[2] = 3;
            last[3] = 1;
            last[4] = 2;

            if (dir == 1 || dir == 2) maxW = dis;
            else maxH = dis;
            firstDis = dis;
            lastDir = dir;
            lastDis = dis;
        }

        public void addData(int dir, int dis) {
            if (empty == 0 && lastDir == last[dir]) empty = lastDis * dis;
            if (dir == 1 || dir == 2) maxW = Math.max(maxW, dis);
            else if (dir == 3 || dir == 4) maxH = Math.max(maxH, dis);
            lastDis = dis;
            lastDir = dir;
        }

        public int count() {
            return (maxW * maxH - (empty == 0 ? firstDis * lastDis : empty)) * NUM;
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