package LeetCode.LeetCode_75_Level_2.Day_13_Dynamic_Programming.Medium.Partition_Equal_Subset_Sum.HashSet_solution;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new LeetCode.LeetCode_75_Level_2.Day_13_Dynamic_Programming.Medium.Partition_Equal_Subset_Sum.Dynamic_Programming_solution.Solution().canPartition(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        int sum = 0;

        for (int num : nums) sum += num;

        if ((sum & 1) == 1) return false;

        sum /= 2;
        for (int num : nums) {
            Set<Integer> inter = new HashSet<>();

            for (int n : dp) {
                if (n + num == sum) return true;
                inter.add(n + num);
                inter.add(n);
            }
            dp = inter;
        }
        return false;
    }
}
