package LeetCode.LeetCode_75.Prefix_Sum.Easy.Find_the_Highest_Altitude;

public class Solution {

    public int largestAltitude(int[] gain) {
        int[] prefSum = new int[gain.length + 1];
        int highestAltitude = 0;

        for (int i = 0; i < gain.length; i++) {
            highestAltitude = Math.max(highestAltitude, prefSum[i + 1] = prefSum[i] + gain[i]);
        }
        return highestAltitude;
    }
}
