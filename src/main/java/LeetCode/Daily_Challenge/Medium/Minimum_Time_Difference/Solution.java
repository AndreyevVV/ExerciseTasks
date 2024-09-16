package LeetCode.Daily_Challenge.Medium.Minimum_Time_Difference;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) return 0;

        List<Integer> minutesList = timePoints.stream()
                .map(this::timeToMinutes)
                .sorted()
                .collect(Collectors.toList());

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minutesList.size(); i++)
            minDiff = Math.min(minDiff, minutesList.get(i) - minutesList.get(i - 1));

        int circularDiff = 1440 + minutesList.get(0) - minutesList.get(minutesList.size() - 1);
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }

    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
