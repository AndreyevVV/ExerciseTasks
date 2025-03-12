package LeetCode.Daily_Challenge.Easy.Maximum_Count_of_Positive_Integer_and_Negative_Integer;

public class Solution {

    public int maximumCount(int[] nums) {
        int negCount = findFirstNonNegativeIndex(nums);
        int posCount = nums.length - findFirstPositiveIndex(nums);
        return Math.max(negCount, posCount);
    }

    private int findFirstNonNegativeIndex(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int findFirstPositiveIndex(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
