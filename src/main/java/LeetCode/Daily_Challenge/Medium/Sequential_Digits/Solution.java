package LeetCode.Daily_Challenge.Medium.Sequential_Digits;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        Set<Integer> result = new TreeSet<>();

        for (int i = 1; i <= 9; i++)
            generateSequentialDigits(i, low, high, result);

        return new ArrayList<>(result);
    }

    private void generateSequentialDigits(int current, int low, int high, Set<Integer> result) {
        if (current > high)
            return;

        if (current >= low && current <= high)
            result.add(current);

        int lastDigit = current % 10;

        if (lastDigit < 9) {
            int next = current * 10 + (lastDigit + 1);
            generateSequentialDigits(next, low, high, result);
        }
    }
}
