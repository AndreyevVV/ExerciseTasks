package LeetCode.Problems.Easy.Binary_Watch.Iterative_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++)
            for (int minute = 0; minute < 60; minute++)
                if (countBits(hour) + countBits(minute) == turnedOn)
                    result.add(String.format("%d:%02d", hour, minute));

        return result;
    }

    private int countBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
