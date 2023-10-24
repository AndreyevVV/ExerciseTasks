package LeetCode.Top_Interview_150.Binary_Tree_General.Medium.Sum_Root_to_Leaf_Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode root = new TreeNode(1, two, three);

        return sumNumbers(root);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return -1;

        List<Integer> numbers = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        Stack<Integer> buildNumbers = new Stack<>();
        buildNumbers.add(root.val);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            Integer num = buildNumbers.pop();

            if (node.left == null && node.right == null) numbers.add(num);

            if (node.right != null) {
                nodes.push(node.right);
                buildNumbers.push(num * 10 + node.right.val);
            }
            if (node.left != null) {
                nodes.push(node.left);
                buildNumbers.push(num * 10 + node.left.val);
            }
        }
        return numbers.stream().mapToInt(Integer::valueOf).sum();
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
