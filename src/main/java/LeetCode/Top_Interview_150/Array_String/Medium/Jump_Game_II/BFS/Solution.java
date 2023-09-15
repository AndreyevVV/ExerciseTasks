package LeetCode.Top_Interview_150.Array_String.Medium.Jump_Game_II.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public int jump(int[] nums) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int count = 0; count < size; count++) {
                int curr = queue.remove();
                if (curr == nums.length - 1) return answer;
                if (nums[curr] == -1) continue;
                for (int i = curr + 1; i <= Math.min(nums.length - 1, curr + nums[curr]); i++)
                    if (nums[i] != -1)
                        queue.add(i);
                nums[curr] = -1;
            }
            answer++;
        }
        return -1;
    }
}
