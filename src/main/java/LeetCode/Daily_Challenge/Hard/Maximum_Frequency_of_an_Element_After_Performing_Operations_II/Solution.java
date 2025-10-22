package LeetCode.Daily_Challenge.Hard.Maximum_Frequency_of_an_Element_After_Performing_Operations_II;

import java.util.Arrays;

public class Solution {
    
    private int countWithinRange(int[] nums, long target, int range, int maxOps) {
        int lowInRange = lowerBound(nums, target);
        int highInRange = upperBound(nums, target);

        int lowTotal = lowerBound(nums, target - range);
        int highTotal = upperBound(nums, target + range);

        int outside = (highTotal - highInRange) + (lowInRange - lowTotal);

        return Math.min(maxOps, outside) + (highInRange - lowInRange);
    }

    private int lowerBound(int[] arr, long target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int upperBound(int[] arr, long target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int maxFreq = 1;

        for (int num : nums) {
            maxFreq = Math.max(maxFreq, countWithinRange(nums, num, k, numOperations));
            maxFreq = Math.max(maxFreq, countWithinRange(nums, num - k, k, numOperations));
            maxFreq = Math.max(maxFreq, countWithinRange(nums, num + k, k, numOperations));
        }

        return maxFreq;
    }
}
