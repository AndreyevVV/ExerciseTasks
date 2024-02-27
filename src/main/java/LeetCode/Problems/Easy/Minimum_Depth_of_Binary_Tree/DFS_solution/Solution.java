package LeetCode.Problems.Easy.Minimum_Depth_of_Binary_Tree.DFS_solution;

import LeetCode.Problems.Easy.Minimum_Depth_of_Binary_Tree.TreeNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        TreeNode seven = new TreeNode(7);
        TreeNode fifteen = new TreeNode(15);
        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode nine = new TreeNode(9);
        TreeNode root = new TreeNode(3, nine, twenty);

        return minDepth(root);
    }

        public int minDepth(TreeNode root) {
            if (root == null) return 0;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            Stack<Integer> depth = new Stack<>();
            depth.push(1);
            int minDepth = Integer.MAX_VALUE;

            while (!stack.isEmpty()) {
                root = stack.pop();
                int localDepth = depth.pop();

                if (root.left == null && root.right == null)
                    minDepth = Math.min(minDepth, localDepth);

                if (root.left != null) {
                    stack.push(root.left);
                    depth.push(localDepth + 1);
                }
                if (root.right != null) {
                    stack.push(root.right);
                    depth.push(localDepth + 1);
                }
            }
            return minDepth;
        }
}
