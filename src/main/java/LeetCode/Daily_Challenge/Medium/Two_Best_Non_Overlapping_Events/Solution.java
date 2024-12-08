package LeetCode.Daily_Challenge.Medium.Two_Best_Non_Overlapping_Events;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Solution {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        TreeMap<Integer, Integer> maxValues = new TreeMap<>();
        int maxSoFar = 0;
        int result = 0;

        for (int[] event : events) {
            int startTime = event[0];
            int endTime = event[1];
            int value = event[2];

            Integer previousEndTime = maxValues.floorKey(startTime - 1);
            int maxValueBefore = (previousEndTime != null) ? maxValues.get(previousEndTime) : 0;

            result = Math.max(result, maxValueBefore + value);

            maxSoFar = Math.max(maxSoFar, value);
            maxValues.put(endTime, maxSoFar);
        }

        return result;
    }
}
