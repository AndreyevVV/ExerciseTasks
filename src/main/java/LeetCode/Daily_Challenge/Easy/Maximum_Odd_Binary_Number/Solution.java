package LeetCode.Daily_Challenge.Easy.Maximum_Odd_Binary_Number;

public class Solution {

    public String maximumOddBinaryNumber(String s) {
        int onesCount = 0;
        for (char character : s.toCharArray())
            if (character == '1')
                onesCount++;

        return "1".repeat(Math.max(0, onesCount - 1)) +
                "0".repeat(Math.max(0, s.length() - onesCount)) +
                '1';
    }
}
