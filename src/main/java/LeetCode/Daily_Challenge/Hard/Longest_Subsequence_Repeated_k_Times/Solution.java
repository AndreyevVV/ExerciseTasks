package LeetCode.Daily_Challenge.Hard.Longest_Subsequence_Repeated_k_Times;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public String longestSubsequenceRepeatedK(String s, int k) {
        String result = "";
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String candidate = current + ch;
                if (isKRepeatedSubsequence(candidate, s, k)) {
                    result = candidate;
                    queue.add(candidate);
                }
            }
        }

        return result;
    }

    private boolean isKRepeatedSubsequence(String subseq, String original, int k) {
        int count = 0, index = 0;

        for (char ch : original.toCharArray()) {
            if (ch == subseq.charAt(index)) {
                index++;
                if (index == subseq.length()) {
                    index = 0;
                    count++;
                    if (count == k) return true;
                }
            }
        }

        return false;
    }
}
