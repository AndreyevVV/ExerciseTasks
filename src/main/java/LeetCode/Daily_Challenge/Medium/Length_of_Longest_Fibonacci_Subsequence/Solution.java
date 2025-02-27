package LeetCode.Daily_Challenge.Medium.Length_of_Longest_Fibonacci_Subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            indexMap.put(arr[i], i);

        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int prev = arr[j] - arr[i];
                if (prev < arr[i] && indexMap.containsKey(prev)) {
                    int k = indexMap.get(prev);
                    int key = k * n + i;
                    int len = dp.getOrDefault(key, 2) + 1;
                    dp.put(i * n + j, len);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen >= 3 ? maxLen : 0;
    }
}
