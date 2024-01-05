package LeetCode.Problems.Medium.Sum_of_Beauty_of_All_Substrings;

public class Solution {
    public static void main(String[] args) {
        String s1 = "aabcb";

        System.out.println("All substrings of s1:");
        printAllSubstrings(s1);
    }

    public static void printAllSubstrings(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    public int beautySum(String s) {
        int beautySum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] charFrequency = new int[26];

            for (int j = i; j < n; j++) {
                charFrequency[s.charAt(j) - 'a']++;

                int maxFrequency = 0;
                int minFrequency = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (charFrequency[k] > 0) {
                        maxFrequency = Math.max(maxFrequency, charFrequency[k]);
                        minFrequency = Math.min(minFrequency, charFrequency[k]);
                    }
                }
                beautySum += maxFrequency - minFrequency;
            }
        }
        return beautySum;
    }
}
