package LeetCode.Daily_Challenge.Hard.Minimum_Difference_in_Sums_After_Removal_of_Elements;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int m = nums.length;

        long[] leftMin = new long[m];
        long[] rightMax = new long[m];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftSum = 0;

        for (int i = 0; i < m; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];

            if (maxHeap.size() > n)
                leftSum -= maxHeap.poll();

            leftMin[i] = (maxHeap.size() == n) ? leftSum : Long.MAX_VALUE;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;

        for (int i = m - 1; i >= 0; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];

            if (minHeap.size() > n)
                rightSum -= minHeap.poll();

            rightMax[i] = (minHeap.size() == n) ? rightSum : Long.MIN_VALUE;
        }

        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++)
            res = Math.min(res, leftMin[i] - rightMax[i + 1]);

        return res;
    }
}
