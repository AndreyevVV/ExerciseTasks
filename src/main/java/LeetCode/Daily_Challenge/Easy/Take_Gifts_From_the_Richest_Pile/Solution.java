package LeetCode.Daily_Challenge.Easy.Take_Gifts_From_the_Richest_Pile;

import java.util.PriorityQueue;

public class Solution {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int gift : gifts)
            maxHeap.add(gift);

        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty())
                break;
            int maxGifts = maxHeap.poll();
            int remainingGifts = (int) Math.floor(Math.sqrt(maxGifts));
            maxHeap.add(remainingGifts);
        }

        long totalGifts = 0;
        while (!maxHeap.isEmpty())
            totalGifts += maxHeap.poll();

        return totalGifts;
    }
}
