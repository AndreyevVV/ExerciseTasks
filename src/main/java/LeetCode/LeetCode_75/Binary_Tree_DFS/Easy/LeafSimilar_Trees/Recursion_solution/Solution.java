package LeetCode.LeetCode_75.Binary_Tree_DFS.Easy.LeafSimilar_Trees.Recursion_solution;

import LeetCode.LeetCode_75.Binary_Tree_DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        else if (root1 == null && root2 != null) return false;
        else if (root1 != null && root2 == null) return false;

        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        dfs(root1, leaf1);
        dfs(root2, leaf2);

        if (leaf1.size() != leaf2.size()) return false;

        for (int i = 0; i < leaf1.size(); i++) {
            if (!Objects.equals(leaf1.get(i), leaf2.get(i))) {
                return false;
            }
        }

        return true;
    }

    private void dfs(TreeNode root, List<Integer> leafs) {
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
            return;
        }
        if (root.left != null) dfs(root.left, leafs);
        if (root.right != null) dfs(root.right, leafs);
    }
}
