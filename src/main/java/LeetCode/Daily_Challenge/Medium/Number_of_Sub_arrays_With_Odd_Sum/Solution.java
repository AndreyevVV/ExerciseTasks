package LeetCode.Daily_Challenge.Medium.Number_of_Sub_arrays_With_Odd_Sum;

public class Solution {

    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int odd = 0, even = 1, sum = 0, count = 0;

        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                count = (count + odd) % MOD;
                even++;
            } else {
                count = (count + even) % MOD;
                odd++;
            }
        }

        return count;
    }
}
