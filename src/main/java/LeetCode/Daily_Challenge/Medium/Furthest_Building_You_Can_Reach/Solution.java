package LeetCode.Daily_Challenge.Medium.Furthest_Building_You_Can_Reach;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                heap.offer(diff);
                if (heap.size() > ladders)
                    bricks -= heap.poll();

                if (bricks < 0)
                    return i;
            }
        }
        return heights.length - 1;
    }
}
