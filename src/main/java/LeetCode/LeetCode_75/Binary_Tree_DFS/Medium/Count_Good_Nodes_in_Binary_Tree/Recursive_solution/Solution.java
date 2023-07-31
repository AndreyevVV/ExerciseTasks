package LeetCode.LeetCode_75.Binary_Tree_DFS.Medium.Count_Good_Nodes_in_Binary_Tree.Recursive_solution;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

public class Solution {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int maximumValue) {
        if (root == null) return 0;
        int answer;
        if (root.val >= maximumValue) answer = 1;
        else answer = 0;

        answer += dfs(root.left, Math.max(root.val, maximumValue));
        answer += dfs(root.right, Math.max(root.val, maximumValue));
        return answer;
    }
}
