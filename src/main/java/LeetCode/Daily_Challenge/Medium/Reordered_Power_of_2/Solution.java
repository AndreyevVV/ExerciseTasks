package LeetCode.Daily_Challenge.Medium.Reordered_Power_of_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    public boolean reorderedPowerOf2(int n) {
        Set<String> signatures = new HashSet<>();
        for (int i = 0; i < 31; i++)
            signatures.add(getSignature(1 << i));
        return signatures.contains(getSignature(n));
    }

    private String getSignature(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}
