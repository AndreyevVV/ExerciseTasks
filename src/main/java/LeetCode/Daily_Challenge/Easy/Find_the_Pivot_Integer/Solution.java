package LeetCode.Daily_Challenge.Easy.Find_the_Pivot_Integer;

public class Solution {

    public int pivotInteger(int n) {
        if (n == 1) return 1;
        int left = 1;

        for (int i = 2; i <= n; i++)
            if (((left + i) * i) / 2 == ((i + n) * (n - i + 1)) / 2)
                return i;

        return -1;
    }
}
