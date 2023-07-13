package LeetCode.LeetCode_75.Two_Pointers.Medium.Max_Number_of_K_Sum_Pairs.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxOperations(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for (int num : nums) {
            if (num >= k) continue;
            else {
                Integer operand = map.get(k - num);
                if (operand != null && operand != 0) {
                    map.put(k - num, --operand);
                    answer++;
                } else {
                    Integer value = map.get(num);
                    if (value != null) map.put(num, ++value);
                    else map.put(num, 1);
                }
            }
        }
        return answer;
    }
}
