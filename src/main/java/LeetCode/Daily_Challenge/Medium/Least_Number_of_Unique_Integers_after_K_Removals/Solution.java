package LeetCode.Daily_Challenge.Medium.Least_Number_of_Unique_Integers_after_K_Removals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        minHeap.addAll(map.keySet());

        for (int i = 0; i < k; i++) {
            int element = minHeap.poll();
            map.put(element, map.get(element) - 1);
            if (map.get(element) > 0)
                minHeap.add(element);
        }

        int uniqueCount = 0;
        for (int count : map.values())
            if (count > 0)
                uniqueCount++;

        return uniqueCount;
    }
}
