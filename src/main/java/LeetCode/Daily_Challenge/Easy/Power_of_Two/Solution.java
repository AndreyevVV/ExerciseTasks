package LeetCode.Daily_Challenge.Easy.Power_of_Two;

public class Solution {

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
