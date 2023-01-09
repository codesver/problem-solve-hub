import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder result = new StringBuilder();

    private static final Map<Character, Node> map = new HashMap<>();

    private static void solution() throws IOException {
        int N = Integer.parseInt(reader.readLine());
        IntStream.range(0, N).forEach(alp -> map.put((char) (alp + 65), new Node((char) (alp + 65))));
        while (N-- > 0) {
            String relation = reader.readLine();
            Node parent = map.get(relation.charAt(0));
            char left = relation.charAt(2);
            char right = relation.charAt(4);
            if (left != '.') parent.setLeft(map.get(left));
            if (right != '.') parent.setRight(map.get(right));
        }
        Node node = map.get('A');
        preOrder(node);
        result.append("\n");
        inOrder(node);
        result.append("\n");
        postOrder(node);
    }

    private static void preOrder(Node node) {
        result.append(node.value);
        if (node.hasLeft()) preOrder(node.left);
        if (node.hasRight()) preOrder(node.right);
    }

    private static void inOrder(Node node) {
        if (node.hasLeft()) inOrder(node.left);
        result.append(node.value);
        if (node.hasRight()) inOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node.hasLeft()) postOrder(node.left);
        if (node.hasRight()) postOrder(node.right);
        result.append(node.value);
    }

    static class Node {
        char value;
        Node left, right;

        public Node(char value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
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