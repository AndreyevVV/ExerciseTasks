package LeetCode.Daily_Challenge.Easy.Find_Lucky_Integer_in_an_Array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

     public static void main(String[] args) {
        Solution finder = new Solution();

        int[] test1 = {2, 2, 3, 4};
        int[] test2 = {1, 2, 2, 3, 3, 3};
        int[] test3 = {2, 2, 2, 3, 3};

        System.out.println("Test 1: " + finder.findLucky(test1)); // Output: 2
        System.out.println("Test 2: " + finder.findLucky(test2)); // Output: 3
        System.out.println("Test 3: " + finder.findLucky(test3)); // Output: -1
    }

    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        
        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        int res = -1;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
            if (entry.getKey().equals(entry.getValue()))
                res = Math.max(res, entry.getKey());

        return res;
    }
}
