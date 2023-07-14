package LeetCode.LeetCode_75.Sliding_Window.Easy.Maximum_Average_Subarray_I;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int leftBorder = 0, rightBorder;
        if (nums.length >= k) rightBorder = k - 1;
        else throw new RuntimeException("Invalid Arguments");

        double maximumAverage = 0, summ = 0;
        for (int i = leftBorder; i <= rightBorder; i++) {
            summ += nums[i];
        }
        maximumAverage = summ / k;
        leftBorder++;
        rightBorder++;

        while (rightBorder < nums.length) {
            summ = summ - nums[leftBorder++ - 1] + nums[rightBorder++];
            maximumAverage = Math.max(maximumAverage, summ / k);
        }
        return maximumAverage;
    }
}
