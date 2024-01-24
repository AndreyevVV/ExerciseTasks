package LeetCode.Daily_Challenge.Medium.Pseudo_Palindromic_Paths_in_a_Binary_Tree;

public class Solution {

    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int count) {
        if (node == null)
            return 0;

        count ^= (1 << node.val);

        if (node.left == null && node.right == null)
            return (count & (count - 1)) == 0 ? 1 : 0;

        int leftPaths = dfs(node.left, count);
        int rightPaths = dfs(node.right, count);

        return leftPaths + rightPaths;
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
