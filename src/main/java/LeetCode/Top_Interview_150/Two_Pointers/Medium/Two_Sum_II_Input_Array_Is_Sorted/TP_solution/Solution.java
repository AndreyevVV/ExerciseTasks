package LeetCode.Top_Interview_150.Two_Pointers.Medium.Two_Sum_II_Input_Array_Is_Sorted.TP_solution;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int keyValue;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) break;
            keyValue = target - numbers[r];
            while (numbers[l] < keyValue) l++;
            if (numbers[l] + numbers[r] == target) break;
            keyValue = target - numbers[l];
            while (numbers[r] > keyValue) r--;
        }
        return new int[]{l + 1, r + 1};
    }
}
