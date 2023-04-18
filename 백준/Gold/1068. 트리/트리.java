import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final StringBuilder result = new StringBuilder();

    static class Node {
        int nno;
        List<Node> children = new ArrayList<>();

        public Node(int nno) {
            this.nno = nno;
        }

        public void addChild(Node node) {
            children.add(node);
        }
    }

    public void solve() throws IOException {
        final int NODE_NUM = Integer.parseInt(reader.readLine());
        Map<Integer, Node> nodes = IntStream.range(0, NODE_NUM).boxed()
                .collect(Collectors.toMap(nno -> nno, Node::new));

        Node root = null;
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int nno = 0; nno < NODE_NUM; nno++) {
            int parentNno = Integer.parseInt(tokenizer.nextToken());
            if (parentNno == -1) root = nodes.get(nno);
            else nodes.get(parentNno).addChild(nodes.get(nno));
        }
        assert root != null;

        int removedNno = Integer.parseInt(reader.readLine());

        int leafCountNum = 0;
        Queue<Node> queue = new LinkedList<>(Collections.singleton(root));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.nno == removedNno) continue;
            List<Node> children = node.children;
            if (children.size() == 0 || (children.size() == 1 && children.get(0).nno == removedNno)) leafCountNum++;
            for (Node child : children) queue.offer(child);
        }

        result.append(leafCountNum);
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