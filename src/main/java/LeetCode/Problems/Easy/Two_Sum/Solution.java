package LeetCode.Problems.Easy.Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int number = target - nums[i];

            if (map.containsKey(number)) {
                return new int[]{i, map.get(number)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
