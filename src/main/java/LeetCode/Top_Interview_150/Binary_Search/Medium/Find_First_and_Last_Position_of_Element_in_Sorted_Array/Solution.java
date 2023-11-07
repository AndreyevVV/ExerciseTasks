package LeetCode.Top_Interview_150.Binary_Search.Medium.Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int left = findFirstIndex(nums, target);
        int right = findLastIndex(nums, target);

        return new int[]{left, right};
    }

    private int findFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;

            if (nums[mid] == target)
                index = mid;
        }
        return index;
    }

    private int findLastIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;

            if (nums[mid] == target)
                index = mid;
        }
        return index;
    }
}
