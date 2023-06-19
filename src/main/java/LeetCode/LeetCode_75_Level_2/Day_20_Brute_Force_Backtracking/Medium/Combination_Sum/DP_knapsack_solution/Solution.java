package LeetCode.LeetCode_75_Level_2.Day_20_Brute_Force_Backtracking.Medium.Combination_Sum.DP_knapsack_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] combList = new List[target + 1];
        combList[0] = new ArrayList<>();
        combList[0].add(new ArrayList<>());

        for (int c : candidates) {
            for (int i = c; i <= target; i++) {
                if (combList[i - c] != null) {
                    if (combList[i] == null)
                        combList[i] = new ArrayList<>();

                    for (List<Integer> list : combList[i - c]) {
                        List<Integer> copy = new ArrayList<>(list);
                        copy.add(c);
                        combList[i].add(copy);
                    }
                }
            }
        }
        return combList[target] == null ? new ArrayList<>() : combList[target];
    }
}
