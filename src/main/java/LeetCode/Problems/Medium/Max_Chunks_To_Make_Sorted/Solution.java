package LeetCode.Problems.Medium.Max_Chunks_To_Make_Sorted;

public class Solution {

    public int maxChunksToSorted(int[] arr) {

        int length = arr.length;
        int chunksNumber = 0;
        int max = 0;

        for (int i = 0; i < length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) chunksNumber++;
        }
        return chunksNumber;
    }
}
