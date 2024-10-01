package LeetCode.Daily_Challenge.Medium.Check_If_Array_Pairs_Are_Divisible_by_k;

public class Solution {

    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];

        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            remainderCount[remainder]++;
        }

        for (int i = 1; i < k; i++)
            if (remainderCount[i] != remainderCount[k - i])
                return false;

        if (remainderCount[0] % 2 != 0)
            return false;

        return true;
    }
}
