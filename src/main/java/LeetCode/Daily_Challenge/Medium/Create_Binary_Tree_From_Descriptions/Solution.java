package LeetCode.Daily_Challenge.Medium.Create_Binary_Tree_From_Descriptions;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] descriptions1 = { {20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1} };
        TreeNode root1 = solution.createBinaryTree(descriptions1);
        System.out.println(solution.levelOrderTraversal(root1));

        int[][] descriptions2 = { {1, 2, 1}, {2, 3, 0}, {3, 4, 1} };
        TreeNode root2 = solution.createBinaryTree(descriptions2);
        System.out.println(solution.levelOrderTraversal(root2));
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.put(parentVal, parentNode);

            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, childNode);

            if (isLeft)
                parentNode.left = childNode;
            else
                parentNode.right = childNode;

            children.add(childVal);
        }

        TreeNode root = null;
        for (int key : nodeMap.keySet()) {
            if (!children.contains(key)) {
                root = nodeMap.get(key);
                break;
            }
        }

        return root;
    }

    public List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode != null) {
                result.add(currentNode.val);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            } else
                result.add(null);
        }

        while (result.get(result.size() - 1) == null)
            result.remove(result.size() - 1);

        return result;
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
