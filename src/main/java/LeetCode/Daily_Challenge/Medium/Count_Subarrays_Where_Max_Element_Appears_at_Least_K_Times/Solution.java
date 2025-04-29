package LeetCode.Daily_Challenge.Medium.Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times;

public class Solution {

    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
            if (nums[i] > max)
                max = nums[i];

        int i = 0;
        int countMax = 0;
        long result = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] == max)
                countMax++;

            while (countMax >= k) {
                result += (n - j);
                if (nums[i] == max)
                    countMax--;
                i++;
            }
        }

        return result;
    }
}
