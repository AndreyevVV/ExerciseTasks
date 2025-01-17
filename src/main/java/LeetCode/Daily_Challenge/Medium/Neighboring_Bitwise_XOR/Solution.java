package LeetCode.Daily_Challenge.Medium.Neighboring_Bitwise_XOR;

public class Solution {

    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        if (isValid(derived, 0))
            return true;

        return isValid(derived, 1);
    }

    private boolean isValid(int[] derived, int first) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = first;

        for (int i = 1; i < n; i++)
            original[i] = derived[i - 1] ^ original[i - 1];

        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}
