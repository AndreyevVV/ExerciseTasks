package LeetCode.Daily_Challenge.Medium.Divide_Array_Into_Arrays_With_Max_Difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int[][] divideArray(int[] nums, int k) {
        int size = nums.length;

        if (size % 3 != 0) return new int[0][0];

        Arrays.sort(nums);

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < size; i += 3) {
            if (i + 2 < size && nums[i + 2] - nums[i] <= k)
                result.add(new int[]{nums[i], nums[i + 1], nums[i + 2]});
            else
                return new int[0][0];
        }
        return result.toArray(new int[0][]);
    }
}
