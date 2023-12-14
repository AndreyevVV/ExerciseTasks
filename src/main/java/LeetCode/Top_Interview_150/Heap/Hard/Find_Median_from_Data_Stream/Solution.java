package LeetCode.Top_Interview_150.Heap.Hard.Find_Median_from_Data_Stream;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        MedianFinder medianFinder = new Solution().new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2.0
    }

    class MedianFinder {
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek())
                maxHeap.offer(num);
            else
                minHeap.offer(num);

            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.offer(maxHeap.poll());
            else if (minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size())
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            else
                return maxHeap.peek();
        }
    }
}
