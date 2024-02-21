package LeetCode.Problems.Medium.Find_The_Original_Array_of_Prefix_Xor;

public class Solution {

    public int[] findArray(int[] pref) {
        if (pref == null || pref.length == 0) return new int[]{};
        int n = pref.length;
        if (n == 1) return pref;

        int[] originalArray = new int[n];
        originalArray[0] = pref[0];

        for (int i = n - 1; i >= 1; i--)
            originalArray[i] = pref[i] ^ pref[i - 1];

        return originalArray;
    }
}
