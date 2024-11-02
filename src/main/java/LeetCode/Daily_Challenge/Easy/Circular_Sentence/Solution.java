package LeetCode.Daily_Challenge.Easy.Circular_Sentence;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isCircularSentence(" leetcode  exercises    sound     delightful "));
    }

    public boolean isCircularSentence(String sentence) {
        sentence = sentence.trim();

        if (sentence.charAt(0) == sentence.charAt(sentence.length() - 1)) {
            char first;
            char last;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    first = sentence.charAt(i - 1);
                    while (i < sentence.length() - 1 && sentence.charAt(i + 1) == ' ') i++;
                    last = sentence.charAt(i + 1);
                    if (first != last) return false;
                }
            }
            return true;
        }

        return false;
    }
}
