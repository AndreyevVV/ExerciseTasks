package LeetCode.Daily_Challenge.Medium.Number_of_Good_Leaf_Nodes_Pairs;

public class Solution {

    public int countPairs(TreeNode root, int distance) {
        if (root == null)
            return 0;

        int[] result = new int[1];

        dfs(root, distance, result);

        return result[0];
    }

    private int[] dfs(TreeNode node, int distance, int[] result) {
        if (node == null)
            return new int[distance + 1];

        if (node.left == null && node.right == null) {
            int[] leaves = new int[distance + 1];
            leaves[1] = 1;
            return leaves;
        }

        int[] left = dfs(node.left, distance, result);
        int[] right = dfs(node.right, distance, result);

        for (int i = 1; i <= distance; i++)
            for (int j = 1; j <= distance; j++)
                if (i + j <= distance)
                    result[0] += left[i] * right[j];

        int[] leaves = new int[distance + 1];
        for (int i = 1; i < distance; i++)
            leaves[i + 1] = left[i] + right[i];

        return leaves;
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
