package LeetCode.Algorithms.Easy.Single_Number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = Arrays.stream(nums).boxed().collect(Collectors.toMap(e1 -> e1, e2 -> 0, (e1, e2) -> e1,
                HashMap::new));

        Arrays.stream(nums).forEach(i -> map.computeIfPresent(i, (k, v) -> v + 1));

        return map.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
}
