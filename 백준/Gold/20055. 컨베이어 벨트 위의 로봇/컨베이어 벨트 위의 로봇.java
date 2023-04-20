import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int lengthOfBelt = Integer.parseInt(tokenizer.nextToken()) * 2;
        int limitNumberOfBrokenBlock = Integer.parseInt(tokenizer.nextToken());
        List<Integer> durabilities = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        ConveyorBelt conveyorBelt = new ConveyorBelt(durabilities, limitNumberOfBrokenBlock);
        int numberOfStepsRan = conveyorBelt.run();
        result.append(numberOfStepsRan);
    }

    public void finish() throws IOException {
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

class ConveyorBelt {

    private final List<Block> blocks;

    private int limitNumberOfBrokenBlock;

    public ConveyorBelt(List<Integer> durabilities, int limitNumberOfBrokenBlock) {
        blocks = durabilities.stream().map(Block::new).collect(Collectors.toList());
        this.limitNumberOfBrokenBlock = limitNumberOfBrokenBlock;
    }

    public int run() {
        int step = 0;
        while (true) {
            step++;
            rotateConveyorBelt();
            moveRobots();
            addNewRobot();
            if (limitNumberOfBrokenBlock <= 0) return step;
        }
    }

    public void rotateConveyorBelt() {
        blocks.add(0, blocks.remove(blocks.size() - 1));
        checkAndDropRobot();
    }

    public void moveRobots() {
        for (int loc = blocks.size() / 2 - 1; loc >= 0; loc--) {
            Block block = blocks.get(loc);
            Block nextBlock = blocks.get(loc + 1);
            if (block.hasRobot() && nextBlock.canPutRobot()) {
                int leftDurability = block.moveRobotToNextBlock(nextBlock);
                if (leftDurability == 0) limitNumberOfBrokenBlock--;
            }
        }
        checkAndDropRobot();
    }

    private void addNewRobot() {
        Block putBlock = blocks.get(0);
        if (putBlock.canPutRobot()) {
            int leftDurability = putBlock.putRobot();
            if (leftDurability == 0) limitNumberOfBrokenBlock--;
        }
    }

    public void checkAndDropRobot() {
        Block dropBlock = blocks.get(blocks.size() / 2 - 1);
        if (dropBlock.hasRobot()) dropBlock.dropRobot();
    }
}

class Block {

    private int durability;
    private boolean hasRobot;

    public Block(int durability) {
        this.durability = durability;
    }

    public boolean hasRobot() {
        return hasRobot;
    }

    public boolean canPutRobot() {
        return !hasRobot && durability > 0;
    }

    public int putRobot() {
        hasRobot = true;
        return --durability;
    }

    public void dropRobot() {
        hasRobot = false;
    }

    public int moveRobotToNextBlock(Block nextBlock) {
        dropRobot();
        return nextBlock.putRobot();
    }
}