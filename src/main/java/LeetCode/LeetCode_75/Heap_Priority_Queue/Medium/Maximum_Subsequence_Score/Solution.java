package LeetCode.LeetCode_75.Heap_Priority_Queue.Medium.Maximum_Subsequence_Score;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int length = nums1.length;
        int[][] mapIndToVal = new int[length][2];

        for (int i = 0; i < length; i++)
            mapIndToVal[i] = new int[]{nums1[i], nums2[i]};

        Arrays.sort(mapIndToVal, (a, b) -> b[1] - a[1]);

        long answer = 0, subSeqSum = 0;
        var heap = new PriorityQueue<Integer>();

        for (var i = 0; i < length; i++) {
            heap.offer(mapIndToVal[i][0]);
            subSeqSum += mapIndToVal[i][0];

            if (i >= k) subSeqSum -= heap.poll();

            if (i >= k - 1) answer = Math.max(answer, subSeqSum * mapIndToVal[i][1]);
        }
        return answer;
    }
}
