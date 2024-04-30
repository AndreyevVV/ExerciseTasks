package LeetCode.Daily_Challenge.Medium.Number_of_Wonderful_Substrings.Straightforward_solution;

public class Solution {

    public long wonderfulSubstrings(String word) {
        long result = 0;

        for (int start = 0; start < word.length(); start++) {
            int[] count = new int[26];
            int oddCount = 0;

            for (int end = start; end < word.length(); end++) {
                char c = word.charAt(end);
                count[c - 'a']++;

                if (count[c - 'a'] % 2 == 1)
                    oddCount++;
                else
                    oddCount--;

                if (oddCount <= 1)
                    result++;
            }
        }
        return result;
    }
}
