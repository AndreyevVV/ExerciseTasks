package LeetCode.Daily_Challenge.Easy.Maximum_Difference_by_Remapping_a_Digit;

public class Solution {

    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        char maxReplace = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxReplace = c;
                break;
            }
        }
        String maxStr = s;
        if (maxReplace != ' ')
            maxStr = s.replace(maxReplace, '9');

        char minReplace = s.charAt(0);
        String minStr = s.replace(minReplace, '0');

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
