package LeetCode.Daily_Challenge.Medium.Maximum_Length_of_a_Concatenated_String_with_Unique_Characters.DP_solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int maxLength(List<String> arr) {
        int n = arr.size();
        int[] dp = new int[1 << n];
        int result = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            Set<Character> charSet = new HashSet<>();
            boolean isValid = true;
            int currentLength = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    for (char c : arr.get(i).toCharArray()) {
                        if (!charSet.add(c)) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) break;
                    currentLength += arr.get(i).length();
                }
            }

            if (isValid) {
                dp[mask] = currentLength;
                result = Math.max(result, dp[mask]);
            }
        }
        return result;
    }
}
