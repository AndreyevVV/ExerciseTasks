package LeetCode.Daily_Challenge.Easy.Power_of_Two.AlterSolution;

public class Solution {
    
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (1073741824 % n == 0); // 2^30 = 1073741824
    }
}
