package LeetCode.Daily_Challenge.Easy.Maximum_Score_After_Splitting_a_String;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxScore("011101"));
    }

    public int maxScore(String s) {
        int n = s.length(), zerosCount = 0, onesCount = 0;

        int[] zero = new int[n];
        int[] ones = new int[n];

        for (int i = 0, j= n - 1; i < n && j >=0; i++, j--) {
            if (s.charAt(i) == '0') zero[i] = ++zerosCount;
            if (s.charAt(j) == '1') ones[j] = ++onesCount;

        }
        
        int maxScore = 0;

        for (int i = 1; i < n; i++) {
            maxScore = Math.max(maxScore, ones[i] + zero[i - 1]);
        }
        return maxScore;
    }
}
