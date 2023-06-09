package LeetCode.LeetCode_75_Level_2.Day_15_Tree.Medium.Binary_Tree_Right_Side_View.Iterative_solution;

import LeetCode.LeetCode_75_Level_2.Day_15_Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private List<Integer> start() {

        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, null, four);
        TreeNode root = new TreeNode(1, two, three);
        return rightSideView(root);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            list.add(queue.peek().val);

            int elemntsOnLevel = queue.size();

            for (int i = 0; i < elemntsOnLevel; i++) {
                root = queue.poll();

                if (root.right != null) queue.add(root.right);
                if (root.left != null) queue.add(root.left);
            }
        }
        return list;
    }
}
