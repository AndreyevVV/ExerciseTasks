package LeetCode.Problems.Easy.Intersection_of_Two_Arrays_II;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = Arrays.stream(nums1).boxed()
                .collect(Collectors.toMap(Function.identity(), value -> 1, (e1, e2) -> e1 + 1, HashMap::new));

        Map<Integer, Integer> map2 = Arrays.stream(nums2).boxed()
                .collect(Collectors.toMap(Function.identity(), value -> 1, (e1, e2) -> e1 + 1, HashMap::new));

        List<Integer> list = new ArrayList<>();

        map1.forEach((key, value) -> {
            int value2 = Optional.ofNullable(map2.get(key)).orElse(0);
            int count = value2 != 0 ? value < value2 ? value : value2 : 0;
            for (int i = 0; i < count; i++) list.add(key);
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
