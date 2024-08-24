package LeetCode.Daily_Challenge.Hard.Find_the_Closest_Palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nearestPalindromic("123")); // "121"
        System.out.println(solution.nearestPalindromic("1"));   // "0"
        System.out.println(solution.nearestPalindromic("10"));  // "9"
    }

    private long createPalindrome(long half, boolean isEvenLength) {
        String halfStr = Long.toString(half);
        String reversed = new StringBuilder(halfStr).reverse().toString();
        return Long.parseLong(isEvenLength ? halfStr + reversed : halfStr + reversed.substring(1));
    }

    public String nearestPalindromic(String n) {
        int len = n.length();
        long originalNum = Long.parseLong(n);
        long firstHalf = Long.parseLong(n.substring(0, (len + 1) / 2));

        List<Long> candidates = new ArrayList<>(Arrays.asList(
                createPalindrome(firstHalf, len % 2 == 0),
                createPalindrome(firstHalf + 1, len % 2 == 0),
                createPalindrome(firstHalf - 1, len % 2 == 0),
                (long) Math.pow(10, len - 1) - 1,
                (long) Math.pow(10, len) + 1
        ));

        long closestPalindrome = -1;
        for (long candidate : candidates) {
            if (candidate != originalNum &&
                    (closestPalindrome == -1 ||
                            Math.abs(candidate - originalNum) < Math.abs(closestPalindrome - originalNum) ||
                            (Math.abs(candidate - originalNum) == Math.abs(closestPalindrome - originalNum) && candidate < closestPalindrome))) {
                closestPalindrome = candidate;
            }
        }

        return String.valueOf(closestPalindrome);
    }
}
