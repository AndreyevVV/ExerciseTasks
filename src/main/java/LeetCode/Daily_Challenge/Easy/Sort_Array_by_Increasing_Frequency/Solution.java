package LeetCode.Daily_Challenge.Easy.Sort_Array_by_Increasing_Frequency;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(numsArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int freqA = frequencyMap.get(o1);
                int freqB = frequencyMap.get(o2);
                if (freqA != freqB)
                    return freqA - freqB;
                else
                    return o2 - o1;
            }
        });

        return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
    }
}
