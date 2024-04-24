package LeetCode.Problems.Easy.Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);


        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for (int j = 1; j < i; j++)
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));

            currentRow.add(1);

            prevRow = currentRow;
        }
        return prevRow;
    }
}
