package LeetCode.Daily_Challenge.Medium.Count_Days_Without_Meetings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(m -> m[0]));
        int unvisited = 0, currentDay = 1;

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            if (currentDay < start) {
                unvisited += start - currentDay;
            }

            currentDay = Math.max(currentDay, end + 1);
            if (currentDay > days) break;
        }

        return unvisited + Math.max(0, days - currentDay + 1);
    }
}
