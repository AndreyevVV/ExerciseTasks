package LeetCode.LeetCode_75_Level_1.Day_7_Binary_Search.Easy.Binary_Search;

public class Solution {

    public int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

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
