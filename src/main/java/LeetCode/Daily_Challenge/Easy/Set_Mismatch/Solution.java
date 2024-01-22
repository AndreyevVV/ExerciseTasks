package LeetCode.Daily_Challenge.Easy.Set_Mismatch;

import java.util.Arrays;

public class Solution {

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];

        Arrays.sort(nums);

        int repetition = -1, loss = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                repetition = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                loss = nums[i - 1] + 1;
        }

        if (nums[n - 1] != n)
            loss = n;

        result[0] = repetition;
        result[1] = loss;

        return result;
    }
}
