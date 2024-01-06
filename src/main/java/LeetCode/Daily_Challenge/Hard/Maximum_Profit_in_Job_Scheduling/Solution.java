package LeetCode.Daily_Challenge.Hard.Maximum_Profit_in_Job_Scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int currentProfit = jobs[i].profit;
            int prevJobIndex = binarySearch(jobs, i);

            if (prevJobIndex != -1)
                currentProfit += dp[prevJobIndex];

            dp[i] = Math.max(currentProfit, dp[i - 1]);
        }
        return dp[n - 1];
    }

    private static int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (jobs[mid].endTime <= jobs[index].startTime) {
                if (jobs[mid + 1].endTime <= jobs[index].startTime)
                    low = mid + 1;
                else
                    return mid;
            } else
                high = mid - 1;
        }
        return -1;
    }

    class Job {
        int startTime, endTime, profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
