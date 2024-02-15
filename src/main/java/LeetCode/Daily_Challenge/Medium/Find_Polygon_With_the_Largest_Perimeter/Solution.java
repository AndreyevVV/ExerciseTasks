package LeetCode.Daily_Challenge.Medium.Find_Polygon_With_the_Largest_Perimeter;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
    }

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = Arrays.stream(nums).asLongStream().sum();

        for (int i = nums.length - 1; i >= 2; i--) {
            sum -= nums[i];
            if (sum > nums[i])
                return sum + nums[i];
        }
        return -1;
    }
}
