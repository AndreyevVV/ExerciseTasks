package LeetCode.Recursion_I.Conclusion.Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new ArrayList[n + 1][n + 1];
        return memo(1, n, dp);
    }

    List<TreeNode> memo(int low, int limit, List<TreeNode>[][] dp) {
        if (low > limit) {
            List<TreeNode> answer = new ArrayList<>();
            answer.add(null);
            return answer;
        }
        if (dp[low][limit] != null) return dp[low][limit];

        dp[low][limit] = new ArrayList<>();

        for (int i = low; i <= limit; i++) {
            List<TreeNode> left = memo(low, i - 1, dp);
            List<TreeNode> right = memo(i + 1, limit, dp);
            for (TreeNode l : left)
                for (TreeNode r : right)
                    dp[low][limit].add(new TreeNode(i, l, r));
        }
        return dp[low][limit];
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
