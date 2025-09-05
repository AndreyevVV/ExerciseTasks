package LeetCode.Daily_Challenge.Medium.Minimum_Operations_to_Make_the_Integer_Zero;

public class Solution {
    
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long target = (long) num1 - (long) k * num2;
            if (target < k) continue; 
            int bits = Long.bitCount(target);
            if (bits <= k && k <= target)
                return k;
        }
        return -1;
    }
}
