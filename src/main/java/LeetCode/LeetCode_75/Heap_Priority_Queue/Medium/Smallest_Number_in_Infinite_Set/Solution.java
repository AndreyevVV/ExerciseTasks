package LeetCode.LeetCode_75.Heap_Priority_Queue.Medium.Smallest_Number_in_Infinite_Set;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    static class SmallestInfiniteSet {

        private int minElem;
        private Queue<Integer> queue;

        public SmallestInfiniteSet() {
            minElem = 1;
            queue = new PriorityQueue<>();
        }

        public int popSmallest() {
            if (queue.isEmpty()) return minElem++;
            return queue.poll();
        }

        public void addBack(int num) {
            if (num >= minElem || queue.contains(num)) return;
            queue.offer(num);
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}
