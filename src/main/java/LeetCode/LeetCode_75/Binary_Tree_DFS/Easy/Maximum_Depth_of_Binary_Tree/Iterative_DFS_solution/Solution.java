package LeetCode.LeetCode_75.Binary_Tree_DFS.Easy.Maximum_Depth_of_Binary_Tree.Iterative_DFS_solution;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        TreeNode seven = new TreeNode(7);
        TreeNode fifteen = new TreeNode(15);
        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode nine = new TreeNode(9);
        TreeNode root = new TreeNode(3, nine, twenty);

        return maxDepth(root);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        nodes.add(root);
        depths.add(1);
        int maxDepth = 0;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int currentHeight = depths.pop();

            if (node.left != null) {
                depths.add(currentHeight + 1);
                nodes.push(node.left);
            }
            if (node.right != null) {
                depths.add(currentHeight + 1);
                nodes.push(node.right);
            }
            maxDepth = Math.max(maxDepth, currentHeight);
        }
        return maxDepth;
    }
}
