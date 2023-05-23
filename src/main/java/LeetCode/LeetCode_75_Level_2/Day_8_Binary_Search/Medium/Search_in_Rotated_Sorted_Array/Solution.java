package LeetCode.LeetCode_75_Level_2.Day_8_Binary_Search.Medium.Search_in_Rotated_Sorted_Array;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{1,3}, 1));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;
        if (nums.length == 1) return -1;

        int length = nums.length, pivotIndex = 0;

        while (pivotIndex < length - 1 && nums[pivotIndex + 1] > nums[pivotIndex]) pivotIndex++;

        if (target > nums[length - 1]) return binarySearch(0, pivotIndex, target, nums);
        else if (pivotIndex == length - 1) return binarySearch(0, length - 1, target, nums);
        else return binarySearch(pivotIndex + 1, length - 1, target, nums);
    }
    private int binarySearch (int l, int r, int target, int[] nums) {

        while ( l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return mid;

            if (target < nums[mid]) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
