package LeetCode.Daily_Challenge.Medium.Find_the_Prefix_Common_Array_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        Set<Integer> seen = new HashSet<>();
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            if (seen.contains(A[i]))
                commonCount++;
            else
                seen.add(A[i]);

            if (seen.contains(B[i]))
                commonCount++;
            else
                seen.add(B[i]);

            C[i] = commonCount;
        }

        return C;
    }
}
