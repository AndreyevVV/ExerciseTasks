package LeetCode.Problems.Easy.Minimum_Subsequence_in_Non_Increasing_Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> minSubsequence(int[] nums) {

        int length = nums.length;

        int arrSum = Arrays.stream(nums).sum();

        List<Integer> subsequence = new ArrayList<>();

        Integer[] integers = Arrays.stream(nums).boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);

        int subsecSum = 0;

        for (int i = 0; i <= length; i++) {

            arrSum -= integers[i];
            subsecSum += integers[i];
            subsequence.add(integers[i]);

            if (subsecSum > arrSum) {
                break;
            }
        }
        return subsequence;
    }
}

