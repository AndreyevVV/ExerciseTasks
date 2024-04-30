package LeetCode.Daily_Challenge.Medium.Number_of_Wonderful_Substrings.BitMask_solution;

public class Solution {

    public long wonderfulSubstrings(String word) {
        int[] count = new int[1024];
        count[0] = 1;
        int mask = 0;
        long result = 0;

        for (char c : word.toCharArray()) {
            int index = 1 << (c - 'a');

            mask ^= index;

            result += count[mask];

            for (int i = 0; i < 10; i++)
                result += count[mask ^ (1 << i)];

            count[mask]++;
        }

        return result;
    }
}
