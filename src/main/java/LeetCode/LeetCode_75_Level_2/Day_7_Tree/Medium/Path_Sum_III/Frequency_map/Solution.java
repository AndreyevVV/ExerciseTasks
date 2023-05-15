package LeetCode.LeetCode_75_Level_2.Day_7_Tree.Medium.Path_Sum_III.Frequency_map;

import LeetCode.LeetCode_75_Level_2.Day_7_Tree.Medium.Path_Sum_III.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findSum(root, 0, targetSum, map);
    }

    public int findSum(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if (root == null) return 0;

        sum += root.val;
        int rootsCount = 0;

        rootsCount += map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        rootsCount += findSum(root.left, sum, target, map);
        rootsCount += findSum(root.right, sum, target, map);

        map.put(sum, map.get(sum) - 1);
        return rootsCount;
    }
}
