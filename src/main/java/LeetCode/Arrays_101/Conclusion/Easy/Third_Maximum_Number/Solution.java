package LeetCode.Arrays_101.Conclusion.Easy.Third_Maximum_Number;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int thirdMax(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(set);

        int numberOfMax = 3;

        if (queue.size() >= numberOfMax) {
            while (--numberOfMax > 0) {
                queue.remove();
            }
        }
        return queue.remove();
    }
}
