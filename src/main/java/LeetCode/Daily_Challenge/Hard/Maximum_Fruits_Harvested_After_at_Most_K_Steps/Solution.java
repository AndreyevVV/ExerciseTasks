package LeetCode.Daily_Challenge.Hard.Maximum_Fruits_Harvested_After_at_Most_K_Steps;

public class Solution {
    
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0, total = 0;

        for (int right = 0; right < n; right++) {
            total += fruits[right][1];

            while (left <= right && !isReachable(fruits, left, right, startPos, k)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }

    private boolean isReachable(int[][] fruits, int left, int right, int startPos, int k) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        int steps1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);

        int steps2 = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        return Math.min(steps1, steps2) <= k;
    }
}
