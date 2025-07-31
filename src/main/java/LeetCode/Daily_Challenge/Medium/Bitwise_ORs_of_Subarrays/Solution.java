package LeetCode.Daily_Challenge.Medium.Bitwise_ORs_of_Subarrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);
            for (int x : prev)
                curr.add(x | num);
            result.addAll(curr);
            prev = curr;
        }

        return result.size();
    }    
}
