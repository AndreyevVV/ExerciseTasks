package LeetCode.Recursion_I.Recurrence_Relation.Pascals_Triangle_II.Memoization_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        Integer[][] memArray = new Integer[rowIndex + 1][rowIndex + 1];

        for (int i = 0; i <= rowIndex; i++) row.add(fill(rowIndex, i, memArray));
        return row;
    }

    int fill(int rowIndex, int columnIndex, Integer[][] memArray) {

        if (columnIndex == 0 || rowIndex == columnIndex) return 1;
        if (memArray[rowIndex][columnIndex] != null) return memArray[rowIndex][columnIndex];

        int value = fill(rowIndex - 1, columnIndex - 1, memArray) + fill(rowIndex - 1, columnIndex, memArray);
        memArray[rowIndex][columnIndex] = value;
        return value;
    }
}
