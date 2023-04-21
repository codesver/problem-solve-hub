import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    public void solve() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        ClassRoom classRoom = new ClassRoom(N);
        int studentNum = N * N;
        while (studentNum-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int sno = Integer.parseInt(tokenizer.nextToken());
            Set<Integer> preferSnos = new HashSet<>() {{
                while (tokenizer.hasMoreTokens()) add(Integer.parseInt(tokenizer.nextToken()));
            }};
            classRoom.arrangeStudent(sno, preferSnos);
        }
        result.append(classRoom.calculateTotalPreference());
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

class ClassRoom {

    private final Student[][] students;
    private final int SIZE;

    public ClassRoom(int size) {
        students = new Student[size][size];
        SIZE = size;
    }

    public void arrangeStudent(int sno, Set<Integer> preferSnos) {
        ArrangeDTO arrange = new ArrangeDTO(-1, -1, -1, -1);
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (students[i][j] == null) arrange = arrange.max(ifArrangeAt(i, j, preferSnos));
        students[arrange.getArrangeI()][arrange.getArrangeJ()] = new Student(sno, preferSnos);
    }

    private ArrangeDTO ifArrangeAt(int locI, int locJ, Set<Integer> preferSnos) {
        int preferCount = 0, blankCount = 0;
        for (Adjacent adjacent : Adjacent.values()) {
            try {
                Student friend = students[locI + adjacent.row][locJ + adjacent.col];
                if (friend == null) blankCount++;
                else if (friend.isPreferred(preferSnos)) preferCount++;
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
        }
        return new ArrangeDTO(preferCount, blankCount, locI, locJ);
    }

    public int calculateTotalPreference() {
        int satisfactionScore = 0;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                satisfactionScore += students[i][j].calculateSatisfaction(i, j, students);
        return satisfactionScore;
    }
}

class Student {

    private final int SNO;

    private final Set<Integer> preferSnos;

    public Student(int SNO, Set<Integer> preferSnos) {
        this.SNO = SNO;
        this.preferSnos = preferSnos;
    }

    public boolean isPreferred(Set<Integer> preferSnos) {
        return preferSnos.contains(SNO);
    }

    public int calculateSatisfaction(int locI, int locJ, Student[][] students) {
        int numberOfPreferredFriend = 0;
        for (Adjacent adjacent : Adjacent.values()) {
            try {
                Student student = students[locI + adjacent.row][locJ + adjacent.col];
                if (student.isPreferred(preferSnos)) numberOfPreferredFriend++;
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
        }
        return calculateSatisfaction(numberOfPreferredFriend);
    }
    private int calculateSatisfaction(int numberOfPreferredFriend) {
        switch (numberOfPreferredFriend) {
            case 1:
                return 1;
            case 2:
                return 10;
            case 3:
                return 100;
            case 4:
                return 1000;
            default:
                return 0;
        }
    }
}

class ArrangeDTO {

    private final int numberOfPreferredFriend;
    private final int numberOfEmptySeat;
    private final int arrangeI, arrangeJ;

    public ArrangeDTO(int numberOfPreferredFriend, int numberOfEmptySeat, int arrangeI, int arrangeJ) {
        this.numberOfPreferredFriend = numberOfPreferredFriend;
        this.numberOfEmptySeat = numberOfEmptySeat;
        this.arrangeI = arrangeI;
        this.arrangeJ = arrangeJ;
    }

    public ArrangeDTO max(ArrangeDTO compareTo) {
        if (numberOfPreferredFriend < compareTo.numberOfPreferredFriend) return compareTo;
        else if (numberOfPreferredFriend == compareTo.numberOfPreferredFriend
                && numberOfEmptySeat < compareTo.numberOfEmptySeat) return compareTo;
        return this;
    }

    public int getArrangeI() {
        return arrangeI;
    }

    public int getArrangeJ() {
        return arrangeJ;
    }
}

enum Adjacent {
    NORTH(-1, 0),
    EAST(0, 1),
    SOUTH(1, 0),
    WEST(0, -1);

    final int row, col;

    Adjacent(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }
}