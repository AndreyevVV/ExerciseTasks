package LeetCode.LeetCode_75.Binary_Tree_DFS.Medium.Longest_ZigZag_Path_in_a_Binary_Tree.Recursive_solution;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        TreeNode seven = new TreeNode(1);
        TreeNode six = new TreeNode(1, null, seven);
        TreeNode five = new TreeNode(1);
        TreeNode four = new TreeNode(1, null, six);
        TreeNode three = new TreeNode(1, four, five);
        TreeNode two = new TreeNode(1);
        TreeNode one = new TreeNode(1, two, three);
        TreeNode root = new TreeNode(1, null, one);

        return longestZigZag(root);
    }

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        int[] maxZigZagPath = {0};

        dfs(root, true, 0, maxZigZagPath);
        dfs(root, false, 0, maxZigZagPath);

        return maxZigZagPath[0];
    }

    private void dfs(TreeNode root, boolean left, int curLen, int[] maxZigZagPath) {
        if (root == null) return;

        maxZigZagPath[0] = Math.max(curLen, maxZigZagPath[0]);

        if (left) {
            dfs(root.right, false, curLen++, maxZigZagPath);
            dfs(root.left, true, 1, maxZigZagPath);
        } else {
            dfs(root.left, true, curLen++, maxZigZagPath);
            dfs(root.right, false, 1, maxZigZagPath);
        }
    }
}
