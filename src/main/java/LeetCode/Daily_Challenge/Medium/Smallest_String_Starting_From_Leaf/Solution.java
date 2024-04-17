package LeetCode.Daily_Challenge.Medium.Smallest_String_Starting_From_Leaf;

public class Solution {

    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, new StringBuilder()).toString();
    }

    private StringBuilder dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return sb;

        sb.append((char) ('a' + node.val));

        if (node.left == null && node.right == null)
            return sb.reverse();

        StringBuilder leftPath = dfs(node.left, new StringBuilder(sb));
        StringBuilder rightPath = dfs(node.right, new StringBuilder(sb));

        if (node.left == null) return rightPath;
        if (node.right == null) return leftPath;

        if (leftPath.toString().compareTo(rightPath.toString()) <= 0)
            return leftPath;
        else
            return rightPath;
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
