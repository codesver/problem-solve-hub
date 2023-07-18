import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        // Input : N -> Row size, M -> Column size, R -> Number of command
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int R = Integer.parseInt(tokenizer.nextToken());

        // Input : Base array
        int[][] array = new int[N][M];
        for (int n = 0; n < N; n++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int m = 0; m < M; m++) {
                array[n][m] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        ArrayConverter arrayConverter = new ArrayConverter(array);

        // Input : Command Type -> Convert array with by command
        tokenizer = new StringTokenizer(reader.readLine());
        while (R-- > 0) {
            int command = Integer.parseInt(tokenizer.nextToken());
            arrayConverter.convert(command);
        }

        // Get final array after following every command
        array = arrayConverter.getArray();

        // Output : Print final array
        for (int[] nums : array) {
            for (int num : nums) result.append(num).append(" ");
            result.append('\n');
        }
    }

    public void submit() throws IOException {
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
        main.submit();
    }
}

/**
 * Do converting calculations of 2D int array
 */
class ArrayConverter {

    private final List<Element> elements = new ArrayList<>();
    private int rowSize, colSize;

    public ArrayConverter(int[][] elements) {
        rowSize = elements.length;
        colSize = elements[0].length;
        for (int r = 0; r < rowSize; r++)
            for (int c = 0; c < colSize; c++)
                this.elements.add(new Element(r, c, elements[r][c]));
    }

    /**
     * Get array of current state
     * @return Current array
     */
    public int[][] getArray() {
        int[][] array = new int[rowSize][colSize];
        elements.forEach(element -> array[element.row][element.col] = element.data);
        return array;
    }

    /**
     * Reads command and convert array
     * @param command Command type 1, 2, 3, 4, 5, 6
     */
    public void convert(int command) {
        switch (command) {
            case 1 -> invertVertical();
            case 2 -> invertHorizontal();
            case 3 -> rotateClockwise();
            case 4 -> rotateCounterClockwise();
            case 5 -> rotateSectionClockwise();
            case 6 -> rotateSectionCounterClockwise();
        }
    }

    /**
     * Invert array in vertical direction
     */
    private void invertVertical() {
        elements.forEach(element -> element.row = rowSize - element.row - 1);
    }

    /**
     * Invert array in horizontal direction
     */
    private void invertHorizontal() {
        elements.forEach(element -> element.col = colSize - element.col - 1);
    }

    /**
     * Rotate array in clockwise based on middle of array
     */
    private void rotateClockwise() {
        elements.forEach(element -> {
            int preRow = element.row;
            element.row = element.col;
            element.col = rowSize - preRow - 1;
        });
        int preRowSize = rowSize;
        rowSize = colSize;
        colSize = preRowSize;
    }

    /**
     * Rotate array in counterclockwise based on middle of array
     */
    private void rotateCounterClockwise() {
        elements.forEach(element -> {
            int preCol = element.col;
            element.col = element.row;
            element.row = colSize - preCol - 1;
        });
        int preColSize = colSize;
        colSize = rowSize;
        rowSize = preColSize;
    }

    /**
     * Rotate array by section (1 -> 2 -> 3 -> 4 -> 1)
     */
    private void rotateSectionClockwise() {
        elements.forEach(element -> {
            switch (checkSection(element)) {
                case 1 -> element.col += colSize / 2;
                case 2 -> element.row += rowSize / 2;
                case 3 -> element.col -= colSize / 2;
                case 4 -> element.row -= rowSize / 2;
            }
        });
    }

    /**
     * Rotate array by section (1 -> 4 -> 3 -> 2 -> 1)
     */
    private void rotateSectionCounterClockwise() {
        elements.forEach(element -> {
            switch (checkSection(element)) {
                case 1 -> element.row += rowSize / 2;
                case 2 -> element.col -= colSize / 2;
                case 3 -> element.row -= rowSize / 2;
                case 4 -> element.col += colSize / 2;
            }
        });
    }

    /**
     * Check the element section
     * @param element Element with row and column
     * @return Section number (1, 2, 3, 4)
     */
    private int checkSection(Element element) {
        if (element.row < rowSize / 2 && element.col < colSize / 2) return 1;
        else if (element.row < rowSize / 2) return 2;
        else if (element.col < colSize / 2) return 4;
        else return 3;
    }
}

class Element {

    int row, col;
    final int data;

    public Element(int row, int col, int data) {
        this.row = row;
        this.col = col;
        this.data = data;
    }
}