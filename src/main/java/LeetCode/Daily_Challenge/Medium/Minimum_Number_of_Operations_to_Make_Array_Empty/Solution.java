package LeetCode.Daily_Challenge.Medium.Minimum_Number_of_Operations_to_Make_Array_Empty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19}));
    }

    public int minOperations(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return -1;

        Map<Integer, Integer> map = Arrays.stream(nums).boxed().collect(Collectors.toMap(Function.identity()
                , value -> 1, (e1, e2) -> e1 + 1, HashMap::new));

        System.out.println(map);

        int count = 0;

        for (int value : map.values()) {
            if (value == 1)
                return -1;
            if (value % 3 == 0)
                count += value / 3;
            else if ((value - 2) % 3 == 0)
                count = count + 1 + (value - 2) / 3;
            else if ((value - 4) % 3 == 0)
                count = count + 2 + (value - 4) / 3;
        }
        return count;
    }
}

