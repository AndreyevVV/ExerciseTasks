package LeetCode.Daily_Challenge.Easy.Count_Equal_and_Divisible_Pairs_in_an_Array;

public class Solution {

    public int countPairs(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (nums[i] == nums[j] && (i * j) % k == 0)
                    count++;

        return count;
    }
}
