package LeetCode.Daily_Challenge.Hard.Find_the_Count_of_Good_Integers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    private long res;
    private final Set<String> visited = new HashSet<>();

    public long countGoodIntegers(int total, int divisor) {
        res = 0;
        visited.clear();
        genPalindromes(new int[total], 0, total - 1, divisor, total);
        return res;
    }

    private void genPalindromes(int[] palin, int left, int right, int k, int n) {
        if (left > right) {
            long num = toNumber(palin);
            if (num % k == 0) {
                Map<Integer, Integer> freq = digitFrequency(palin);
                String key = freq.toString();
                if (visited.add(key))
                    res += countValidPermutations(freq, n);
            }
            return;
        }

        for (int d = (left == 0 ? 1 : 0); d <= 9; d++) {
            palin[left] = palin[right] = d;
            genPalindromes(palin, left + 1, right - 1, k, n);
        }
    }

    private long toNumber(int[] digits) {
        long num = 0;
        for (int d : digits)
            num = num * 10 + d;
        return num;
    }

    private Map<Integer, Integer> digitFrequency(int[] digits) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int d : digits)
            freq.merge(d, 1, Integer::sum);
        return freq;
    }

    private long countValidPermutations(Map<Integer, Integer> freq, int totalDigits) {
        long total = totalPermutations(freq, totalDigits);
        long zeroStart = leadingZeroPermutations(new HashMap<>(freq), totalDigits);
        return total - zeroStart;
    }

    private long totalPermutations(Map<Integer, Integer> freq, int total) {
        long res = factorial(total);
        for (int count : freq.values())
            res /= factorial(count);
        return res;
    }

    private long leadingZeroPermutations(Map<Integer, Integer> freq, int total) {
        if (freq.getOrDefault(0, 0) == 0) return 0;

        freq.computeIfPresent(0, (k, v) -> v - 1);
        long res = factorial(total - 1);
        for (int count : freq.values())
            res /= factorial(count);
        return res;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}
