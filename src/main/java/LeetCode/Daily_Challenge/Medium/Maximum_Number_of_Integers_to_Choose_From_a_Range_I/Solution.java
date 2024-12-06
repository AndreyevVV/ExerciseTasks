package LeetCode.Daily_Challenge.Medium.Maximum_Number_of_Integers_to_Choose_From_a_Range_I;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();

        for (int num : banned)
            bannedSet.add(num);

        int count = 0;
        int currentSum = 0;

        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i) || currentSum + i > maxSum)
                continue;
            currentSum += i;
            count++;
        }

        return count;
    }
}
