package LeetCode.Daily_Challenge.Medium.Separate_Black_and_White_Balls;

public class Solution {

    public long minimumSteps(String s) {
        long totalSwaps = 0;
        int blackBalls = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                totalSwaps += blackBalls;
            else
                blackBalls++;
        }

        return totalSwaps;
    }
}
