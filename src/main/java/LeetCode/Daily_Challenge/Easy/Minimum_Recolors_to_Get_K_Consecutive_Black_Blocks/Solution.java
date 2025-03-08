package LeetCode.Daily_Challenge.Easy.Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks;

public class Solution {

    public int minimumRecolors(String blocks, int k) {
        int minWhite = k, countWhite = 0;

        for (int i = 0; i < k; i++)
            if (blocks.charAt(i) == 'W')
                countWhite++;

        minWhite = countWhite;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W')
                countWhite++;
            if (blocks.charAt(i - k) == 'W')
                countWhite--;
            minWhite = Math.min(minWhite, countWhite);
        }

        return minWhite;
    }
}
