package LeetCode.Daily_Challenge.Medium.Minimum_Limit_of_Balls_in_a_Bag;

public class Solution {

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;

        for (int num : nums)
            right = Math.max(right, num);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, maxOperations, mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean canDivide(int[] nums, int maxOperations, int target) {
        int operations = 0;
        for (int num : nums) {
            operations += (num - 1) / target;

            if (operations > maxOperations)
                return false;
        }
        return true;
    }
}
