package LeetCode.LeetCode_75.Prefix_Sum.Easy.Find_Pivot_Index;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().pivotIndex(new int[] {1,7,3,6,5,6}));
    }

    public int pivotIndex(int[] nums) {
        int[] prefSum = new int[nums.length + 1], postSum = new int[nums.length + 1];

        for (int i = 0, j = nums.length - 1; i < nums.length && j > 0; i++, j--) {
            prefSum[i + 1] = prefSum[i] + nums[i];
            postSum[j - 1] = postSum[j] + nums[j];
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefSum[i] == postSum[i] ) return i;
        }
        return -1;
    }
}
