package LeetCode.Daily_Challenge.Medium.Alternating_Groups_II;

public class Solution {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, count = 1, result = 0;

        for (int i = 0; i < n + k - 2; ++i) {
            if (colors[i % n] != colors[(i + 1) % n])
                count++;
            else
                count = 1;
            result += (count >= k) ? 1 : 0;
        }

        return result;
    }
}
