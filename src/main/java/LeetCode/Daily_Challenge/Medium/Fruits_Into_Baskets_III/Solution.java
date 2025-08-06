package LeetCode.Daily_Challenge.Medium.Fruits_Into_Baskets_III;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int blockSize = (int) Math.sqrt(n);
        List<Integer> blockMax = new ArrayList<>();

        for (int i = 0; i < n; i += blockSize) {
            int maxVal = 0;
            for (int j = i; j < Math.min(i + blockSize, n); j++)
                maxVal = Math.max(maxVal, baskets[j]);
            blockMax.add(maxVal);
        }

        int unplaced = 0;

        for (int fruit : fruits) {
            boolean placed = false;

            for (int block = 0, i = 0; i < n; block++, i += blockSize) {
                if (blockMax.get(block) < fruit) continue;

                for (int j = i; j < Math.min(i + blockSize, n); j++) {
                    if (baskets[j] >= fruit) {
                        baskets[j] = 0;
                        placed = true;

                        int newMax = 0;
                        for (int k = i; k < Math.min(i + blockSize, n); k++)
                            newMax = Math.max(newMax, baskets[k]);
                        blockMax.set(block, newMax);
                        break;
                    }
                }

                if (placed) break;
            }

            if (!placed) unplaced++;
        }

        return unplaced;
    }
}
