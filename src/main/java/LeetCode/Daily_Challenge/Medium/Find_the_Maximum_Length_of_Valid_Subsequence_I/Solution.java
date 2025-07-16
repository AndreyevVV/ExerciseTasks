package LeetCode.Daily_Challenge.Medium.Find_the_Maximum_Length_of_Valid_Subsequence_I;

public class Solution {
    
    public int maximumLength(int[] nums) {
        int even = 0, odd = 0;
        for (int num : nums) {
            if (num % 2 == 0) even++;
            else odd++;
        }

        int sameParity = Math.max(even, odd);

        int alt1 = alternating(nums, 0);
        int alt2 = alternating(nums, 1);

        return Math.max(sameParity, Math.max(alt1, alt2));
    }

    private int alternating(int[] nums, int startParity) {
        int count = 0;
        int expected = startParity;
        for (int num : nums) {
            if (num % 2 == expected) {
                count++;
                expected ^= 1;
            }
        }
        return count;
    }
}
