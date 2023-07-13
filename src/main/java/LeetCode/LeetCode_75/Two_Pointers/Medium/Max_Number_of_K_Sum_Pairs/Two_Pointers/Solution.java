package LeetCode.LeetCode_75.Two_Pointers.Medium.Max_Number_of_K_Sum_Pairs.Two_Pointers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    public int maxOperations(int[] nums, int k) {
        if (nums == null) return 0;
        int length = nums.length - 1;
        if (length == 0) return 0;
        Arrays.parallelSort(nums);
        int left = 0, right = length;
        int answer = 0;

        while (left < right) {
            if (nums[left] + nums[right] == k) {
                answer++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < k) left++;
            else right--;
        }
        return answer;
    }
}
