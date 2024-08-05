package LeetCode.Daily_Challenge.Easy.Kth_Distinct_String_in_an_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = Arrays.stream(arr).collect(Collectors.toMap(Function.identity(),
                value -> 1, (e1, e2) -> e1 + e2, LinkedHashMap::new));

        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .skip(k - 1)
                .findFirst()
                .orElse("");
    }
}
