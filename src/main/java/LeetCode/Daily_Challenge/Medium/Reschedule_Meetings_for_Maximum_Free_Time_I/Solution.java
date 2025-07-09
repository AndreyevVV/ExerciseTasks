package LeetCode.Daily_Challenge.Medium.Reschedule_Meetings_for_Maximum_Free_Time_I;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int eventTime1 = 5;
        int k1 = 1;
        int[] startTime1 = {1, 3};
        int[] endTime1 = {2, 5};
        System.out.println(solution.maxFreeTime(eventTime1, k1, startTime1, endTime1)); // Output: 2

        // Test case 2
        int eventTime2 = 10;
        int k2 = 1;
        int[] startTime2 = {0, 2, 9};
        int[] endTime2 = {1, 4, 10};
        System.out.println(solution.maxFreeTime(eventTime2, k2, startTime2, endTime2)); // Output: 6

        // Test case 3
        int eventTime3 = 5;
        int k3 = 2;
        int[] startTime3 = {0, 1, 2, 3, 4};
        int[] endTime3 = {1, 2, 3, 4, 5};
        System.out.println(solution.maxFreeTime(eventTime3, k3, startTime3, endTime3)); // Output: 0
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int maxFree = 0;

        int[] durationPrefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int duration = endTime[i] - startTime[i];
            durationPrefixSum[i + 1] = durationPrefixSum[i] + duration;
        }

        for (int i = k - 1; i < n; i++) {
            int movedDuration = durationPrefixSum[i + 1] - durationPrefixSum[i - k + 1];
            int fixedWindowStart = (i == k - 1) ? 0 : endTime[i - k];
            int fixedWindowEnd = (i == n - 1) ? eventTime : startTime[i + 1];

            int freeTime = fixedWindowEnd - fixedWindowStart - movedDuration;
            maxFree = Math.max(maxFree, freeTime);
        }

        return maxFree;
    }
}