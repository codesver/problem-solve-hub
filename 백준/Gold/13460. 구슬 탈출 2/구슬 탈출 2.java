import java.awt.*;
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State {

    Point red, blue;
    int time;

    public State() {
    }

    public State(Point red, Point blue, int time) {
        this.red = red;
        this.blue = blue;
        this.time = time;
    }
}

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    private final int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private char[][] board;
    private boolean[][][][] searched;

    public void solve() throws IOException {
        int time = search(input());
        result.append(time);
    }

    private int search(State initState) {
        Queue<State> states = new LinkedList<>(Collections.singleton(initState));
        while (!states.isEmpty()) {
            State state = states.poll();
            if (state == null) continue;
            if (board[state.red.x][state.red.y] == 'O') return state.time;
            if (state.time == 10) continue;
            if (!searched[state.red.x][state.red.y][state.blue.x][state.blue.y]) {
                searched[state.red.x][state.red.y][state.blue.x][state.blue.y] = true;
                for (int dir = 0; dir < 4; dir++) states.offer(tilt(state, dir));
            }
        }
        return -1;
    }

    private State tilt(State state, int direction) {
        int[] red = move(state.red, direction);
        int[] blue = move(state.blue, direction);
        if (red[0] == blue[0] && red[1] == blue[1]) {
            if (board[red[0]][red[1]] != 'O') {
                if (red[2] > blue[2]) {
                    red[0] -= moves[direction][0];
                    red[1] -= moves[direction][1];
                } else {
                    blue[0] -= moves[direction][0];
                    blue[1] -= moves[direction][1];
                }
            } else return null;
        } else if (board[blue[0]][blue[1]] == 'O') return null;
        return new State(new Point(red[0], red[1]), new Point(blue[0], blue[1]), state.time + 1);
    }

    private int[] move(Point ball, int direction) {
        int row = ball.x;
        int col = ball.y;
        int count = 0;

        while (true) {
            row += moves[direction][0];
            col += moves[direction][1];
            count++;
            if (board[row][col] == 'O') break;
            else if (board[row][col] == '#') {
                row -= moves[direction][0];
                col -= moves[direction][1];
                count--;
                break;
            }
        }

        return new int[]{row, col, count};
    }

    private State input() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int ROW = Integer.parseInt(tokenizer.nextToken());
        int COL = Integer.parseInt(tokenizer.nextToken());
        board = new char[ROW][COL];
        searched = new boolean[ROW][COL][ROW][COL];

        State state = new State();
        for (int row = 0; row < ROW; row++) {
            String rowLine = reader.readLine();
            for (int col = 0; col < COL; col++) {
                board[row][col] = rowLine.charAt(col);
                if (board[row][col] == 'R') {
                    state.red = new Point(row, col);
                    board[row][col] = '.';
                } else if (board[row][col] == 'B') {
                    state.blue = new Point(row, col);
                    board[row][col] = '.';
                }
            }
        }
        return state;
    }

    private void finish() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.finish();
    }
}