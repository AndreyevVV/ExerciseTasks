package LeetCode.LeetCode_75.Hash_Map_Set.Easy.Find_the_Difference_of_Two_Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < 2; i++) answer.add(new ArrayList<>());

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        for (Integer num : set1) {
            if (set2.contains(num)) {
                set2.remove(num);
            } else answer.get(0).add(num);
        }

        for (Integer num : set2) {
            answer.get(1).add(num);
        }
        return answer;
    }
}
