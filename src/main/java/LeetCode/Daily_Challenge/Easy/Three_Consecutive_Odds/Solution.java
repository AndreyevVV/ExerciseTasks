package LeetCode.Daily_Challenge.Easy.Three_Consecutive_Odds;

public class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int num : arr) {
            if ((num & 1) == 1) {
                count++;
                if (count == 3)
                    return true;
            } else
                count = 0;
        }

        return false;
    }
}
