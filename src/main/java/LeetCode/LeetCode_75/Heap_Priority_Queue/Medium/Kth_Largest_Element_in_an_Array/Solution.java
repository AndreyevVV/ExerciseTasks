package LeetCode.LeetCode_75.Heap_Priority_Queue.Medium.Kth_Largest_Element_in_an_Array;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(list);

        if (queue.size() >= k) while (--k > 0) queue.remove();
        return queue.remove();
    }
}
