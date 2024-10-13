package LeetCode.Daily_Challenge.Hard.Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new Element(i, 0, value));
            max = Math.max(max, value);
        }

        while (minHeap.size() == nums.size()) {
            Element current = minHeap.poll();

            if (max - current.value < end - start) {
                start = current.value;
                end = max;
            }

            if (current.index + 1 < nums.get(current.list).size()) {
                int nextValue = nums.get(current.list).get(current.index + 1);
                minHeap.offer(new Element(current.list, current.index + 1, nextValue));
                max = Math.max(max, nextValue);
            }
        }

        return new int[]{start, end};
    }

    private static class Element {
        int list;
        int index;
        int value;

        public Element(int list, int index, int value) {
            this.list = list;
            this.index = index;
            this.value = value;
        }
    }
}
