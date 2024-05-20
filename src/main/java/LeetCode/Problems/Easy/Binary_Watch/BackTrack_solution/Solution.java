package LeetCode.Problems.Easy.Binary_Watch.BackTrack_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        backtrack(result, turnedOn, 0, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, int turnedOn, int currentHour, int currentMinute, int start, int count) {
        if (count == turnedOn) {
            if (currentHour < 12 && currentMinute < 60)
                result.add(String.format("%d:%02d", currentHour, currentMinute));
            return;
        }

        for (int i = start; i < 10; i++)
            if (i < 4)
                backtrack(result, turnedOn, currentHour | (1 << i), currentMinute, i + 1, count + 1);
            else
                backtrack(result, turnedOn, currentHour, currentMinute | (1 << (i - 4)), i + 1, count + 1);
    }
}
