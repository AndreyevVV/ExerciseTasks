package LeetCode.Daily_Challenge.Hard.Replace_NonCoprime_Numbers_in_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        
        for (int num : nums) {
            int curr = num;

            while (!stack.isEmpty()) {
                int last = stack.get(stack.size() - 1);
                int g = gcd(last, curr);
                if (g == 1) break;
                curr = lcm(last, curr, g);
                stack.remove(stack.size() - 1);
            }
            stack.add(curr);
        }
        
        return stack;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
    private int lcm(int a, int b, int g) {
        return (int)((long)a / g * b); 
    }
}
