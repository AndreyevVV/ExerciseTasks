package LeetCode.Daily_Challenge.Medium.Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box;

public class Solution {

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int count = 0, ops = 0;

        for (int i = 0; i < n; i++) {
            answer[i] += ops;
            if (boxes.charAt(i) == '1')
                count++;
            ops += count;
        }

        count = 0;
        ops = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += ops;
            if (boxes.charAt(i) == '1')
                count++;
            ops += count;
        }

        return answer;
    }
}
