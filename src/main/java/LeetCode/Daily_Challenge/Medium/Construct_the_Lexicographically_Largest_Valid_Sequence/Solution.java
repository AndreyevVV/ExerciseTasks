package LeetCode.Daily_Challenge.Medium.Construct_the_Lexicographically_Largest_Valid_Sequence;

public class Solution {

    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] result = new int[size];
        boolean[] used = new boolean[n + 1];
        backtrack(result, used, 0, n);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        while (index < result.length && result[index] != 0)
            index++;

        if (index == result.length)
            return true;

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            if (num == 1) {
                result[index] = 1;
                used[1] = true;

                if (backtrack(result, used, index + 1, n))
                    return true;

                result[index] = 0;
                used[1] = false;
            } else {
                int secondIndex = index + num;
                if (secondIndex < result.length && result[secondIndex] == 0) {
                    result[index] = result[secondIndex] = num;
                    used[num] = true;

                    if (backtrack(result, used, index + 1, n))
                        return true;

                    result[index] = result[secondIndex] = 0;
                    used[num] = false;
                }
            }
        }
        return false;
    }
}
