package LeetCode.Daily_Challenge.Medium.Find_All_Duplicates_in_an_Array.Classic_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0)
                result.add(index + 1);

            nums[index] = -nums[index];
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return result;
    }
}
