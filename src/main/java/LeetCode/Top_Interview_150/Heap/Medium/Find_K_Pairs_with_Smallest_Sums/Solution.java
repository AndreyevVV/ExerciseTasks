package LeetCode.Top_Interview_150.Heap.Medium.Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                minHeap.offer(new int[]{num1, num2});
                if (minHeap.size() > k) {
                    minHeap.poll();

                    int currentSum = num1 + num2;
                    int[] maxSumPair = minHeap.peek();
                    if (currentSum >= (maxSumPair[0] + maxSumPair[1])) {
                        break;
                    }
                }
            }
        }

        List<List<Integer>> kPairs = new ArrayList<>();
        int heapSize = minHeap.size();
        for (int i = 0; i < heapSize; i++) {
            int[] pairArr = minHeap.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(pairArr[0]);
            pair.add(pairArr[1]);
            kPairs.add(pair);
        }
        return kPairs;
    }
}
