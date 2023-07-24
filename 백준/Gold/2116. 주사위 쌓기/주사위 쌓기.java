import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        List<Die> dice = new ArrayList<>();
        while (N-- > 0) dice.add(new Die());

        StringTokenizer tokenizer;
        for (Die die : dice) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int index = 1; index <= 6; index++)
                die.addNum(index, Integer.parseInt(tokenizer.nextToken()));
        }

        int maxSideSummation = 0;
        for (int firstBottomNum = 1; firstBottomNum <= 6; firstBottomNum++) {
            int sideSum = 0, bottomNum = firstBottomNum;
            for (Die die : dice) {
                Allocation allocation = die.allocate(bottomNum);
                sideSum += allocation.maxSide;
                bottomNum = allocation.topNum;
            }
            maxSideSummation = Math.max(maxSideSummation, sideSum);
        }

        result.append(maxSideSummation);
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

class Die {

    private final int[] indexToNum = new int[7];
    private final int[] numToIndex = new int[7];

    public void addNum(int index, int num) {
        indexToNum[index] = num;
        numToIndex[num] = index;
    }

    public Allocation allocate(int bottomNum) {
        int topNum = topNum(bottomNum);
        return new Allocation(topNum, maxSide(bottomNum, topNum));
    }

    private int topNum(int bottomNum) {
        int bottomIndex = numToIndex[bottomNum];
        int topIndex = switch (bottomIndex) {
            case 1, 6 -> 7 - bottomIndex;
            case 2, 3 -> bottomIndex + 2;
            case 4, 5 -> bottomIndex - 2;
            default -> throw new IllegalArgumentException("Not allowed index");
        };
        return indexToNum[topIndex];
    }

    private int maxSide(int bottomNum, int topNum) {
        if (bottomNum != 6 && topNum != 6) return 6;
        else if (bottomNum != 5 && topNum != 5) return 5;
        return 4;
    }
}

class Allocation {
    final int topNum;
    final int maxSide;

    public Allocation(int topNum, int maxSide) {
        this.topNum = topNum;
        this.maxSide = maxSide;
    }
}