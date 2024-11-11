package LeetCode.Daily_Challenge.Medium.Prime_Subtraction_Operation;

import java.util.Arrays;

public class Solution {

    public boolean primeSubOperation(int[] nums) {
        int maxElement = getMaxElement(nums);

        boolean[] arr = new boolean[maxElement + 1];
        Arrays.fill(arr, true);
        arr[1] = false;
        for (int i = 2; i <= Math.sqrt(maxElement + 1); i++)
            if (arr[i])
                for (int j = i * i; j <= maxElement; j += i)
                    arr[j] = false;

        int currValue = 1;
        int i = 0;
        while (i < nums.length) {
            int difference = nums[i] - currValue;

            if (difference < 0)
                return false;

            if (arr[difference] || difference == 0) {
                i++;
                currValue++;
            } else
                currValue++;
        }
        return true;
    }

    private int getMaxElement(int[] nums) {
        int max = -1;
        for (int num : nums)
            if (num > max)
                max = num;
        return max;
    }
}
