package LeetCode.Daily_Challenge.Medium.Minimum_Time_to_Repair_Cars;

public class Solution {

    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long) ranks[0] * cars * cars;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAll(ranks, cars, mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private boolean canRepairAll(int[] ranks, int cars, long time) {
        long count = 0;
        for (int rank : ranks) {
            count += (long) Math.sqrt(time / rank);
            if (count >= cars) return true;
        }
        return false;
    }
}
