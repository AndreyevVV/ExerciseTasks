package LeetCode.Top_Interview_150.Hashmap.Easy.Contains_Duplicate_II;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numToIndex.containsKey(num) && i - numToIndex.get(num) <= k)
                return true;
            numToIndex.put(num, i);
        }
        return false;
    }
}
