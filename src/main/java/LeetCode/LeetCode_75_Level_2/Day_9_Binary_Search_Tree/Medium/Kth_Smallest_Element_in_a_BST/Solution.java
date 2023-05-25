package LeetCode.LeetCode_75_Level_2.Day_9_Binary_Search_Tree.Medium.Kth_Smallest_Element_in_a_BST;

public class Solution {

    int count = 0;
    int kthMin = 0;

    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2, one, null);
        TreeNode six = new TreeNode(6);
        TreeNode three = new TreeNode(3, two, four);
        TreeNode root = new TreeNode(5, three, six);

        return kthSmallest(root, 3);
    }

    public int kthSmallest(TreeNode root, int k) {
        findKthMin(root, k);
        return kthMin;
    }

    private void findKthMin(TreeNode root, int k) {
        if (root == null) return;

        findKthMin(root.left, k);

        count++;

        if (count == k) {
            kthMin = root.val;
            return;
        }

        findKthMin(root.right, k);
    }
}
