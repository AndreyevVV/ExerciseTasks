package LeetCode.Daily_Challenge.Easy.Sort_the_People;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        int[] heights = {155, 180, 165};
        String[] sortedNames = new Solution().sortPeople(names, heights);
        System.out.println(Arrays.toString(sortedNames));
    }

    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> heights[e2] - heights[e1]);
        for (int i = 0; i < heights.length; i++)
            queue.add(i);

        String[] result = new String[names.length];

        for (int i = 0; i < names.length; i++)
            if (!queue.isEmpty())
                result[i] = names[queue.poll()];

        return result;
    }
}
