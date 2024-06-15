package LeetCode.Problems.Easy.Minimum_Number_Game;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {

    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums)
            pq.add(num);

        int[] arr = new int[nums.length];
        int index = 0;

        while (!pq.isEmpty()) {
            int alice = pq.poll();
            if (!pq.isEmpty()) {
                int bob = pq.poll();
                arr[index++] = bob;
            }
            arr[index++] = alice;
        }
        return arr;
    }
}
