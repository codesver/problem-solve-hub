import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static void solution() throws IOException {
        Tree tree = new Tree(Integer.parseInt(reader.readLine()));
        String line;
        while ((line = reader.readLine()) != null) {
            int value = Integer.parseInt(line);
            tree.addNode(new Tree(value));
        }
        result.append(tree);
    }

    static class Tree {

        int root;
        Tree left, right;

        public Tree(int value) {
            this.root = value;
        }

        public void addNode(Tree tree) {
            if (tree.root < root) {
                if (left == null) left = tree;
                else left.addNode(tree);
            } else {
                if (right == null) right = tree;
                else right.addNode(tree);
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            if (left != null) builder.append(left);
            if (right != null) builder.append(right);
            builder.append(root).append("\n");
            return builder.toString();
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