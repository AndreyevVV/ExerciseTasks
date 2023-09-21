package LeetCode.Top_Interview_150.Two_Pointers.Medium.Two_Sum_II_Input_Array_Is_Sorted.TP_with_BS_solution;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{5, 25, 75}, 100)));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) return new int[]{};
        if (numbers.length == 2) return new int[]{1, 2};

        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1, r = numbers.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                int sum_1_2 = numbers[i] + numbers[mid];
                if (sum_1_2 == target) return new int[]{i + 1, mid + 1};
                else if (sum_1_2 < target) l = mid + 1;
                else r = mid;
            }
        }
        return new int[]{};
    }
}
