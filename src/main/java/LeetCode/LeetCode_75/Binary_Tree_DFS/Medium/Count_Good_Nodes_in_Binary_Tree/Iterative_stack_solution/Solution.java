package LeetCode.LeetCode_75.Binary_Tree_DFS.Medium.Count_Good_Nodes_in_Binary_Tree.Iterative_stack_solution;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(4, four, five);
        TreeNode one = new TreeNode(1, three, null);
        TreeNode root = new TreeNode(3, one, two);

        return goodNodes(root);
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        int goodNodesCount = 0;

        nodeStack.push(root);
        maxStack.push(root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int maxSoFar = maxStack.pop();

            if (node.val >= maxSoFar) {
                goodNodesCount++;
            }

            if (node.left != null) {
                nodeStack.push(node.left);
                maxStack.push(Math.max(maxSoFar, node.left.val));
            }

            if (node.right != null) {
                nodeStack.push(node.right);
                maxStack.push(Math.max(maxSoFar, node.right.val));
            }
        }
        return goodNodesCount;
    }
}
