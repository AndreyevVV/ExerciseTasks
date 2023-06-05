package LeetCode.LeetCode_75_Level_2.Day_14_Sliding_Window_Two_Pointer.Medium.ThreeSum_Closest;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[] {-1,2,1,-4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length, minDiff = Integer.MAX_VALUE, answer = 0;

        for (int i = 0; i < length - 2; i++) {
            int left = i + 1, right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                else if (sum < target) {
                    left++;
                } else {
                    right--;
                }

                int tempMinDiff = Math.abs(target - sum);

                if (tempMinDiff < minDiff) {
                    minDiff = tempMinDiff;
                    answer = sum;
                }
            }
        }
        return answer;
    }
}
