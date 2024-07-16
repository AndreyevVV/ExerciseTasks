package LeetCode.Daily_Challenge.Medium.Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another;

public class Solution {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        findPath(root, startValue, pathToStart);

        StringBuilder pathToDest = new StringBuilder();
        findPath(root, destValue, pathToDest);

        int i = 0;
        while (i < pathToStart.length() && i < pathToDest.length() && pathToStart.charAt(i) == pathToDest.charAt(i))
            i++;

        StringBuilder result = new StringBuilder();
        for (int j = i; j < pathToStart.length(); j++)
            result.append('U');

        result.append(pathToDest.substring(i));

        return result.toString();
    }

    private boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null)
            return false;

        if (root.val == value)
            return true;

        path.append('L');
        if (findPath(root.left, value, path))
            return true;

        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(root.right, value, path))
            return true;

        path.deleteCharAt(path.length() - 1);

        return false;
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
