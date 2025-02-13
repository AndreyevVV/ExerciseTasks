package LeetCode.Daily_Challenge.Medium.Minimum_Operations_to_Exceed_Threshold_Value_II;

import java.util.PriorityQueue;

public class Solution {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums)
            if (num < k)
                pq.offer(num);

        int operations = 0;

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            operations++;

            long newValue = 2L * x + y;
            if (newValue < k)
                pq.offer((int) newValue);
        }

        return pq.isEmpty() ? operations : operations + 1;
    }
}
