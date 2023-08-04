package LeetCode.LeetCode_75.Binary_Tree_BFS.Medium.Maximum_Level_Sum_of_a_Binary_Tree;

import LeetCode.LeetCode_75.Binary_Tree_BFS.Medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        TreeNode two = new TreeNode(0);
        TreeNode four = new TreeNode(-8);
        TreeNode three = new TreeNode(7);
        TreeNode one = new TreeNode(7, three, four);
        TreeNode root = new TreeNode(1, one, two);
        return maxLevelSum(root);
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int maxSum = root.val, level = 0, answer = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int elementsOnLevel = queue.size(), levelSum = 0;
            level++;
            for (int i = 0; i < elementsOnLevel; i++) {
                root = queue.poll();
                levelSum += root.val;
                if (root.right != null) queue.add(root.right);
                if (root.left != null) queue.add(root.left);
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                answer = level;
            }
        }
        return answer;
    }
}
