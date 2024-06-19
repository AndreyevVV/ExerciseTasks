package LeetCode.Daily_Challenge.Medium.Minimum_Number_of_Days_to_Make_m_Bouquets;

public class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if ((long) m * k > n)
            return -1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;


        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int total = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            int count = 0;
            while (i < bloomDay.length && count < k && bloomDay[i] <= days) {
                count++;
                i++;
            }

            if (count == k) {
                total++;
                i--;
            }

            if (total >= m)
                return true;
        }
        return false;
    }
}
