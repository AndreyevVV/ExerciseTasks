package LeetCode.Daily_Challenge.Medium.Convert_an_Array_Into_a_2D_Array_With_Conditions.HashMapSolution;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> countNums = Arrays.stream(nums).boxed().collect(Collectors.toMap(
                Function.identity(), value -> 1, (e1, e2) -> e1 + 1, HashMap::new));

        System.out.println(countNums);

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countNums.entrySet()) {
            if (result.size() < entry.getValue())
                for (int i = entry.getValue() - result.size(); i > 0; i--)
                    result.add(new ArrayList<>());

            for (int i = 0; i < entry.getValue(); i++)
                result.get(i).add(entry.getKey());
        }
        return result;
    }
}
