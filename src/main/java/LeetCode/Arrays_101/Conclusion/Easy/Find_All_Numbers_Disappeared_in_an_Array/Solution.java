package LeetCode.Arrays_101.Conclusion.Easy.Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findDisappearedNumbers(new int[]{1, 1, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        int numPointer = 0;
        while (numPointer < nums.length) {

            int position = nums[numPointer] - 1;

            if (nums[numPointer] != nums[position]) {

                nums[numPointer] ^= (nums[position] ^= nums[numPointer]);
                nums[position] ^= nums[numPointer];
            } else {
                numPointer++;
            }
        }
        for (int i = 0; i <= numPointer - 1; i++) {
            if (nums[i] != i + 1) answer.add(i + 1);
        }
        return answer;
    }
}
