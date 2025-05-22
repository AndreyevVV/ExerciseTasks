package LeetCode.Daily_Challenge.Medium.Zero_Array_Transformation_III;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        int qIndex = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int[] delta = new int[n + 1];
        int used = 0;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            while (qIndex < m && queries[qIndex][0] <= i) {
                pq.offer(queries[qIndex][1]);
                qIndex++;
            }

            sum += delta[i];

            while (sum < nums[i]) {
                if (pq.isEmpty()) return -1;

                int r = pq.poll();
                if (r < i) return -1;

                used++;
                delta[i]++;
                if (r + 1 < n) delta[r + 1]--;
                sum++;
            }
        }

        return m - used;
    }
}
