package LeetCode.Daily_Challenge.Easy.Count_Largest_Group;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countLargestGroup(int n) {
        Map<Integer, Integer> groupCount = new HashMap<>();
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            groupCount.put(sum, groupCount.getOrDefault(sum, 0) + 1);
            maxSize = Math.max(maxSize, groupCount.get(sum));
        }

        int count = 0;
        for (int size : groupCount.values()) {
            if (size == maxSize)
                count++;
        }

        return count;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
