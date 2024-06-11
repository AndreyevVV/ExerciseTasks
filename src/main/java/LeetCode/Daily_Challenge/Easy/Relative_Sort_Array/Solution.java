package LeetCode.Daily_Challenge.Easy.Relative_Sort_Array;

import java.util.*;

public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++)
            indexMap.put(arr2[i], i);

        List<Integer> remaining = new ArrayList<>();

        Integer[] result = new Integer[arr1.length];
        int index = 0;

        for (int num : arr1) {
            if (indexMap.containsKey(num))
                result[index++] = num;
            else
                remaining.add(num);
        }

        Collections.sort(remaining);

        for (int num : remaining)
            result[index++] = num;

        Comparator<Integer> comparator = (a, b) -> {
            if (indexMap.containsKey(a) && indexMap.containsKey(b))
                return indexMap.get(a) - indexMap.get(b);
            else if (indexMap.containsKey(a))
                return -1;
            else if (indexMap.containsKey(b))
                return 1;
            else
                return 0;
        };

        Arrays.sort(result, 0, index, comparator);

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
