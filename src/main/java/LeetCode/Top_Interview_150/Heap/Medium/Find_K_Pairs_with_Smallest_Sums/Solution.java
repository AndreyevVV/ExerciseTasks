package LeetCode.Top_Interview_150.Heap.Medium.Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

        for (int i = 0; i < nums1.length && i < k; i++)
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int num1 = current[0];
            int num2 = current[1];
            int index = current[2];

            List<Integer> pair = new ArrayList<>();
            pair.add(num1);
            pair.add(num2);
            result.add(pair);

            if (index + 1 < nums2.length)
                minHeap.offer(new int[]{num1, nums2[index + 1], index + 1});
        }
        return result;
    }
}
