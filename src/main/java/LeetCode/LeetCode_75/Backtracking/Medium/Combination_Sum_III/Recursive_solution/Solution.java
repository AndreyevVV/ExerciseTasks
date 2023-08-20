package LeetCode.LeetCode_75.Backtracking.Medium.Combination_Sum_III.Recursive_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int k, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > target) break;
            current.add(i);
            backtrack(k - 1, target - i, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
