package LeetCode.Daily_Challenge.Medium.Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int right;
        int maxLength = 0;

        for (right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right])
                maxDeque.pollLast();
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right])
                minDeque.pollLast();

            maxDeque.addLast(right);
            minDeque.addLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                if (maxDeque.peekFirst() < left)
                    maxDeque.pollFirst();
                if (minDeque.peekFirst() < left)
                    minDeque.pollFirst();
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
