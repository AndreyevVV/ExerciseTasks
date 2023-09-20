package LeetCode.Top_Interview_150.Two_Pointers.Easy.Valid_Palindrome;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(".,"));
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        s = s.trim();
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) l++;
            else if (!Character.isLetterOrDigit(s.charAt(r))) r--;
            else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
                l++;
                r--;
            }
        }
        return true;
    }
}
