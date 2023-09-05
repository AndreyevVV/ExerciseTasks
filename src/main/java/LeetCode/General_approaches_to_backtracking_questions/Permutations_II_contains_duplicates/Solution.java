package LeetCode.General_approaches_to_backtracking_questions.Permutations_II_contains_duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, boolean[] visited) {
        if (templist.size() == nums.length) list.add(new ArrayList<>(templist));

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            templist.add(nums[i]);
            backtrack(list, templist, nums, visited);
            visited[i] = false;
            templist.remove(templist.size() - 1);
        }
    }
}
