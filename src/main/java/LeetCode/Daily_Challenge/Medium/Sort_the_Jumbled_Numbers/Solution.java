package LeetCode.Daily_Challenge.Medium.Sort_the_Jumbled_Numbers;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] mapping1 = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums1 = {991, 338, 38};
        System.out.println(Arrays.toString(solution.sortJumbled(mapping1, nums1))); // [338, 38, 991]

        int[] mapping2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {789, 456, 123};
        System.out.println(Arrays.toString(solution.sortJumbled(mapping2, nums2))); // [123, 456, 789]
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] numsArray = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++)
            numsArray[i] = nums[i];

        Arrays.sort(numsArray, (a, b) -> {
            long mappedA = getMappedValue(a, mapping);
            long mappedB = getMappedValue(b, mapping);
            return Long.compare(mappedA, mappedB);
        });

        for (int i = 0; i < nums.length; i++)
            nums[i] = numsArray[i];

        return nums;
    }

    private long getMappedValue(int num, int[] mapping) {
        if (num == 0)
            return mapping[0];

        StringBuilder mappedValue = new StringBuilder();
        while (num > 0) {
            int digit = num % 10;
            mappedValue.append(mapping[digit]);
            num /= 10;
        }

        return Long.parseLong(mappedValue.reverse().toString());
    }
}
