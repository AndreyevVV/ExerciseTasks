package LeetCode.Problems.Easy.Contains_Duplicate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = Arrays.stream(nums).boxed().collect(Collectors
                .toMap(Function.identity(), value -> 1, (e1, e2) -> e1 + 1, HashMap::new));

        return map.values().stream().anyMatch(value -> value >= 2);
    }
}
