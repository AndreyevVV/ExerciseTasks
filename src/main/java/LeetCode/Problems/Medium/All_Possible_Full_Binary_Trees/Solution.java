package LeetCode.Problems.Medium.All_Possible_Full_Binary_Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if ((n & 1) == 0)
            return new ArrayList<>();

        if (memo.containsKey(n))
            return memo.get(n);

        List<TreeNode> result = new ArrayList<>();

        if (n == 1)
            result.add(new TreeNode(0));
        else {
            for (int leftNodes = 1; leftNodes < n - 1; leftNodes += 2) {
                List<TreeNode> leftSubtrees = allPossibleFBT(leftNodes);
                List<TreeNode> rightSubtrees = allPossibleFBT(n - 1 - leftNodes);

                for (TreeNode left : leftSubtrees) {
                    for (TreeNode right : rightSubtrees) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }

        memo.put(n, result);
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
