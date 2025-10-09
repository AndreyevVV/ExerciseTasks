package LeetCode.Daily_Challenge.Medium.Find_the_Minimum_Amount_of_Time_to_Brew_Potions;

public class Solution {
    
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] time = new long[n + 1];

        for (int potion = 0; potion < m; potion++) {
            for (int wizard = 0; wizard < n; wizard++)
                time[wizard + 1] = Math.max(time[wizard + 1], time[wizard]) + 
                                (long) skill[wizard] * mana[potion];

            for (int wizard = n - 1; wizard > 0; wizard--)
                time[wizard] = time[wizard + 1] - (long) skill[wizard] * mana[potion];
        }

        return time[n];
    }
}
