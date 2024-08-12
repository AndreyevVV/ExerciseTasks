package LeetCode.Daily_Challenge.Easy.Kth_Largest_Element_in_a_Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        KthLargest obj = new KthLargest(3, new int[]{4, 5, 8, 2});
        List<Integer> list = new ArrayList<>();
        list.add(obj.add(3));
        list.add(obj.add(5));
        list.add(obj.add(10));
        list.add(obj.add(8));
        list.add(obj.add(4));
        System.out.println(list);
    }

    static class KthLargest {
        private final PriorityQueue<Integer> queue;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue<>();

            for (int num : nums)
                add(num);
        }

        public int add(int val) {
            queue.offer(val);

            if (queue.size() > k)
                queue.poll();

            return queue.peek();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
