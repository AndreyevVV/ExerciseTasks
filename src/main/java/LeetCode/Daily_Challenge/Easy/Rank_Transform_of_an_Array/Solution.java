package LeetCode.Daily_Challenge.Easy.Rank_Transform_of_an_Array;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return new int[0];

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            result[i] = rankMap.get(arr[i]);

        return result;
    }
}
