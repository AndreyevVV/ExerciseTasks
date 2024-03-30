package LeetCode.Daily_Challenge.Hard.Subarrays_with_K_Different_Integers;

import java.util.HashMap;

public class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int different = 0;
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

            if (frequency.get(num) == 1)
                different++;

            while (different > k) {
                int leftNum = nums[left++];
                frequency.put(leftNum, frequency.get(leftNum) - 1);

                if (frequency.get(leftNum) == 0)
                    different--;
            }

            if (different == k) {
                int temp = left;

                while (different == k) {
                    count++;
                    int leftNum = nums[temp++];
                    frequency.put(leftNum, frequency.get(leftNum) - 1);

                    if (frequency.get(leftNum) == 0)
                        different--;
                }

                while (temp > left) {
                    int leftNum = nums[--temp];
                    frequency.put(leftNum, frequency.getOrDefault(leftNum, 0) + 1);

                    if (frequency.get(leftNum) == 1)
                        different++;
                }
            }
        }
        return count;
    }
}
