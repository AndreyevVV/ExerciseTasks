package LeetCode.Daily_Challenge.Medium.Distribute_Coins_in_Binary_Tree;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(0);
        root1.right = new TreeNode(0);
        System.out.println(solution.distributeCoins(root1));

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(0);
        System.out.println(solution.distributeCoins(root2));
    }

    int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node   ) {
        if (node == null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        moves += Math.abs(left) + Math.abs(right);

        return node.val + left + right - 1;
    }

    public static class TreeNode {
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
