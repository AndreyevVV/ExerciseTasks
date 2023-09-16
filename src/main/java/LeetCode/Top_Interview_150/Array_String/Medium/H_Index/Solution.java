package LeetCode.Top_Interview_150.Array_String.Medium.H_Index;

public class Solution {

    public int hIndex(int[] c) {
        int l = 0, r = c.length;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            int count = 0;
            for (int j : c) if (j >= mid) count++;
            if (count >= mid) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
