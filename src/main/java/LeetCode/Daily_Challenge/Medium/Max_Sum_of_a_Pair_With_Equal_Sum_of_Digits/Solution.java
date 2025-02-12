package LeetCode.Daily_Challenge.Medium.Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits;

import java.util.HashMap;

public class Solution {

    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (map.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, num + map.get(digitSum));
                map.put(digitSum, Math.max(map.get(digitSum), num));
            } else
                map.put(digitSum, num);
        }

        return maxSum;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
