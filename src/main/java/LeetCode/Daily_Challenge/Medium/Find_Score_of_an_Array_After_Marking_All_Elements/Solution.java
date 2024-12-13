package LeetCode.Daily_Challenge.Medium.Find_Score_of_an_Array_After_Marking_All_Elements;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        long score = 0;

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++)
            indices.add(i);

        indices.sort((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));

        for (int index : indices) {
            if (!marked[index]) {
                score += nums[index];

                marked[index] = true;
                if (index > 0) marked[index - 1] = true;
                if (index < n - 1) marked[index + 1] = true;
            }
        }

        return score;
    }
}
