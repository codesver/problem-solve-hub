import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>(Collections.singleton(root));
        while (!nodes.isEmpty()) {
            long sum = 0;
            int num = nodes.size();
            for (int n = 0; n < num; n++) {
                TreeNode node = nodes.poll();
                sum += node.val;
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
            averages.add(sum / (double) num);
        }
        return averages;
    }
}