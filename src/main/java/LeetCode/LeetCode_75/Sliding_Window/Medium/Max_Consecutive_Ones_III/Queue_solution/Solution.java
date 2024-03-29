package LeetCode.LeetCode_75.Sliding_Window.Medium.Max_Consecutive_Ones_III.Queue_solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int longestOnes(int[] A, int K) {
        Queue<Integer> que = new LinkedList<>();
        int right = 0;
        int left = 0;
        int answer = 0;

        while (right < A.length) {
            if (A[right] == 0) que.add(right);
            if (que.size() == K + 1) left = que.remove() + 1;
            answer = Math.max(right - left + 1, answer);
            right++;
        }
        return answer;
    }
}
