package LeetCode.Daily_Challenge.Medium.Minimum_Deletions_to_Make_String_Balanced;

public class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        int[] countB = new int[n + 1];
        int[] countA = new int[n + 1];

        for (int i = 0; i < n; i++)
            countB[i + 1] = countB[i] + (s.charAt(i) == 'b' ? 1 : 0);

        for (int i = n - 1; i >= 0; i--)
            countA[i] = countA[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);

        int minDeletions = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++)
            minDeletions = Math.min(minDeletions, countB[i] + countA[i]);

        return minDeletions;
    }
}
