package LeetCode.LeetCode_75.Binary_Tree_DFS.Easy.Maximum_Depth_of_Binary_Tree.Iterative_BFS_solution;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}
