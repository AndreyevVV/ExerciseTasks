package LeetCode.Recursion_I.Recurrence_Relation.Pascals_Triangle_II.Recursive_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        if (rowIndex == 0) return List.of(1);

        List<Integer> row = getRow(rowIndex - 1);
        for (int i = 0; i <= rowIndex; i++) {
            list.add((i - 1 < 0 ? 0 : row.get(i - 1)) + (i >= rowIndex ? 0 : row.get(i)));
        }

        return list;
    }
}
