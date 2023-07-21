package LeetCode.LeetCode_75.Hash_Map_Set.Easy.Unique_Number_of_Occurrences;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) return false;

//        Map<Integer, Integer> map = new HashMap<>();
//        for (Integer integer : arr) map.put(integer, map.getOrDefault(integer, 0) + 1);

        Map<Integer, Integer> map = Arrays.stream(arr).boxed().collect(Collectors.toMap(Function.identity(),
                e2 -> 1, (e1, e2) -> e1 + 1, HashMap::new));
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}
