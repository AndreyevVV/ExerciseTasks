package LeetCode.Daily_Challenge.Medium.Take_K_of_Each_Character_From_Left_and_Right;

public class Solution {

    public int takeCharacters(String s, int k) {
        int[] count = new int[3];

        for (char ch : s.toCharArray())
            count[ch - 'a']++;

        if (count[0] < k || count[1] < k || count[2] < k)
            return -1;

        int[] required = {count[0] - k, count[1] - k, count[2] - k};

        int n = s.length();
        int maxWindow = 0;
        int[] windowCount = new int[3];
        int left = 0;

        for (int right = 0; right < n; right++) {
            windowCount[s.charAt(right) - 'a']++;

            while (windowCount[0] > required[0] || windowCount[1] > required[1] || windowCount[2] > required[2]) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }
}
