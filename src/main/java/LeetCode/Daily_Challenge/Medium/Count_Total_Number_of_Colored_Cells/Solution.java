package LeetCode.Daily_Challenge.Medium.Count_Total_Number_of_Colored_Cells;

public class Solution {

    public long coloredCells(int n) {
        return 2L * n * (n - 1) + 1;
    }
}
