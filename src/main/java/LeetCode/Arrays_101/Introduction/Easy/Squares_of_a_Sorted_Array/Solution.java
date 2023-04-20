package LeetCode.Arrays_101.Introduction.Easy.Squares_of_a_Sorted_Array;

public class Solution {

    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1, answerIndex = r;
        int[] answer = new int[nums.length];

        while (l <= r) {
            int max = (Math.abs(nums[l]) < Math.abs(nums[r]) ? nums[r] : nums[l]);

            if (max == nums[r]) r--;
            else l++;

            answer[answerIndex] = max * max;
            answerIndex--;
        }
        return answer;
    }
}
