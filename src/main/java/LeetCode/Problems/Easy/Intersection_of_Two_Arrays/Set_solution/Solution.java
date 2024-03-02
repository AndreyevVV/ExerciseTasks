package LeetCode.Problems.Easy.Intersection_of_Two_Arrays.Set_solution;

import com.sun.source.doctree.SeeTree;

import java.util.*;
import java.util.function.Function;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1)
            set.add(num);

        Set<Integer> answer = new HashSet<>();
        for (int num : nums2)
            if (set.contains(num)) answer.add(num);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
