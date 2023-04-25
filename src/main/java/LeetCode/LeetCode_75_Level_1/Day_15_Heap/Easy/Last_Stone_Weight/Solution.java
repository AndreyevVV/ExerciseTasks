package LeetCode.LeetCode_75_Level_1.Day_15_Heap.Easy.Last_Stone_Weight;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int lastStoneWeight(int[] stones) {

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone: stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {
            int newStone =  queue.remove() - queue.remove();
            if (newStone != 0) queue.add(newStone);
        }
        return queue.isEmpty() ? 0 : queue.remove();
    }
}
