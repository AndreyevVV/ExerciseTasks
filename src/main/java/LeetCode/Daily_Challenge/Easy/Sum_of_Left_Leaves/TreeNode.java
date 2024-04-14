package LeetCode.Daily_Challenge.Easy.Sum_of_Left_Leaves;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
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
        return "{" + val +
                " " + left +
                " " + right +
                '}';
    }
}
