package LeetCode.Daily_Challenge.Medium.Lowest_Common_Ancestor_of_Deepest_Leaves;

public class Solution {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode node) {
        if (node == null)
            return new Pair(null, 0);

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        if (left.depth > right.depth)
            return new Pair(left.node, left.depth + 1);
        else if (left.depth < right.depth)
            return new Pair(right.node, right.depth + 1);
        else
            return new Pair(node, left.depth + 1);
    }

    private static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
