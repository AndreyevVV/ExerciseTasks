package LeetCode.Problems.Medium.Minimum_Time_to_Repair_Cars;


import java.util.Arrays;

public class Solution {

    public long repairCars(int[] ranks, int cars) {

        int maxRank = Arrays.stream(ranks).max().getAsInt();
        long resultTime = 0, r = (long) (maxRank * Math.pow(cars, 2));

        while (resultTime <= r) {

            long mid = resultTime + (r - resultTime) / 2;

            long repairedCars = 0;
            for (int rank : ranks) {
                repairedCars += (long) Math.sqrt(mid / rank);
            }

            if (repairedCars >= cars) {
                r = mid - 1;
            } else {
                resultTime = mid + 1;
            }
        }
        return resultTime;
    }
}
