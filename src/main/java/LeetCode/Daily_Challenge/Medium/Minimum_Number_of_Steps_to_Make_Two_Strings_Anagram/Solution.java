package LeetCode.Daily_Challenge.Medium.Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram;

public class Solution {

    public int minSteps(String s, String t) {
        int[] charsFreq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charsFreq[s.charAt(i) - 'a']++;
            charsFreq[t.charAt(i) - 'a']--;

        }

        int steps = 0;

        for(int dif : charsFreq)
            if (dif > 0) steps += dif;

        return steps;
    }
}
