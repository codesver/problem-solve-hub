import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int R, C;
    public int[][] picture;
    public Queue<Pixel> pixels;

    public int[] solution(int m, int n, int[][] picture) {
        R = m;
        C = n;
        this.picture = new int[R][C];
        for (int r = 0; r < R; r++) System.arraycopy(picture[r], 0, this.picture[r], 0, C);
        int[] res = {0, Integer.MIN_VALUE};
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (this.picture[r][c] != 0) {
                    res[0]++;
                    res[1] = Math.max(res[1], search(new Pixel(r, c, this.picture[r][c])));
                }
            }
        }
        return res;
    }

    public int search(Pixel start) {
        picture[start.row][start.col] = 0;
        pixels = new LinkedList<>(Collections.singleton(start));
        int count = 0;
        while (!pixels.isEmpty()) {
            count++;
            Pixel pixel = pixels.poll();
            check(pixel, new Pixel(pixel.row - 1, pixel.col, pixel.type));
            check(pixel, new Pixel(pixel.row + 1, pixel.col, pixel.type));
            check(pixel, new Pixel(pixel.row, pixel.col - 1, pixel.type));
            check(pixel, new Pixel(pixel.row, pixel.col + 1, pixel.type));
        }
        return count;
    }

    public void check(Pixel base, Pixel pixel) {
        if (0 <= pixel.row && pixel.row < R && 0 <= pixel.col && pixel.col < C
                && base.type == picture[pixel.row][pixel.col]) {
            picture[pixel.row][pixel.col] = 0;
            pixels.offer(pixel);
        }
    }
}

class Pixel {

    int row, col, type;

    public Pixel(int row, int col, int type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }
}