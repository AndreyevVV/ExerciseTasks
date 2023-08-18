package LeetCode.LeetCode_75.Binary_Search.Medium.Koko_Eating_Bananas;

public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0, k = 0;

        for (int j : piles) r = Math.max(r, j);

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midTime = 0;

            for (int pile : piles) midTime += Math.ceil((double) pile / mid);

            if (midTime > h) l = mid + 1;
            else {
                k = mid;
                r = mid - 1;
            }
        }
        return k;
    }
}
