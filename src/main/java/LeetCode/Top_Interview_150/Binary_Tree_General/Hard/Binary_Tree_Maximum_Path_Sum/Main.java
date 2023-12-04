package LeetCode.Top_Interview_150.Binary_Tree_General.Hard.Binary_Tree_Maximum_Path_Sum;

//import LeetCode.Top_Interview_150.Binary_Tree_General.Hard.Binary_Tree_Maximum_Path_Sum.Recursive_Solution.Solution;
import LeetCode.Top_Interview_150.Binary_Tree_General.Hard.Binary_Tree_Maximum_Path_Sum.Iterative_Solution.Solution;
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().start());
    }

    private int start() {

        TreeNode minusTwo = new TreeNode(-2);
        TreeNode minusThree = new TreeNode(-3, new TreeNode(1), new TreeNode(3));
        TreeNode one = new TreeNode(1, minusTwo, minusThree);
        TreeNode minusOne = new TreeNode(-1);
        TreeNode root = new TreeNode(1, one, minusOne);

        return new Solution().maxPathSum(root);
    }
}
