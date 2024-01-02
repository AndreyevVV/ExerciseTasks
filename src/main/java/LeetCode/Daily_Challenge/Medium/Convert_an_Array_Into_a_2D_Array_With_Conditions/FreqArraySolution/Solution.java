package LeetCode.Daily_Challenge.Medium.Convert_an_Array_Into_a_2D_Array_With_Conditions.FreqArraySolution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> findMatrix(int[] nums) {
       int[] freqArray = new int[nums.length];

        ArrayList<List<Integer>> result = new ArrayList<>();

        for(int num : nums) {
            if (freqArray[num] >= result.size())
                result.add(new ArrayList<>());

            result.get(freqArray[num]).add(num);
            freqArray[num]++;
        }
        return result;
    }
}
