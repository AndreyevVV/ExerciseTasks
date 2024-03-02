package LeetCode.Problems.Easy.Intersection_of_Two_Arrays.Arrays_solution;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] temp = new int[1001];
        for (int i : nums1)
            temp[i] = 1;

        int count = 0;

        for (int i : nums2) {
            if (temp[i] == 1) {
                count++;
                temp[i] = 2;
            }
        }

        int[] answer = new int[count];
        int answerIndex = 0;

        for (int i : nums2) {
            if (temp[i] == 2) {
                temp[i] = 1;
                answer[answerIndex] = i;
                answerIndex++;
            }
        }
        return answer;
    }
}
