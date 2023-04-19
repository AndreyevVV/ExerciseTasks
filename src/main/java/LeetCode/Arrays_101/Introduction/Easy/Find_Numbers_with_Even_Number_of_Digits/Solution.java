package LeetCode.Arrays_101.Introduction.Easy.Find_Numbers_with_Even_Number_of_Digits;

public class Solution {

    public int findNumbers(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            int tempNumber = num, count = 0;

            do {
                tempNumber = tempNumber / 10;
                count++;
            } while (tempNumber != 0);

            if (count % 2 == 0) answer++;
        }
        return answer;
    }
}
