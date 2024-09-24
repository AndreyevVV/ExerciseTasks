package LeetCode.Daily_Challenge.Medium.Find_the_Length_of_the_Longest_Common_Prefix;

import java.util.HashMap;

public class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> prefix = new HashMap<>();

        for (int val : arr1) {
            int num = val;
            while (num > 0) {
                prefix.put(num, prefix.getOrDefault(num, 0) + 1);
                num /= 10;
            }
        }

        int maxLength = 0;

        for (int val : arr2) {
            int num = val;
            int len = countDigits(num);

            while (num > 0) {
                if (prefix.containsKey(num))
                    break;
                num /= 10;
                len--;
            }

            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }

    private int countDigits(int num) {
        return (int) Math.log10(num) + 1;
    }
}
