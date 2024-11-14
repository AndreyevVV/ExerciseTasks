package LeetCode.Daily_Challenge.Medium.Minimized_Maximum_of_Products_Distributed_to_Any_Store;

public class Solution {

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 0;

        for (int quantity : quantities)
            right = Math.max(right, quantity);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean canDistribute(int[] quantities, int n, int maxProducts) {
        int storesRequired = 0;
        for (int quantity : quantities)
            storesRequired += (quantity + maxProducts - 1) / maxProducts;
        return storesRequired <= n;
    }
}
