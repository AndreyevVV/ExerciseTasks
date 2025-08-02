package LeetCode.Daily_Challenge.Hard.Rearranging_Fruits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> totalCount = new HashMap<>();
        
        for (int fruit : basket1)
            totalCount.merge(fruit, 1, Integer::sum);

        for (int fruit : basket2)
            totalCount.merge(fruit, 1, Integer::sum);
        
        int minVal = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : totalCount.entrySet()) {
            if (entry.getValue() % 2 != 0) return -1;
            minVal = Math.min(minVal, entry.getKey());
        }

        Map<Integer, Integer> countInBasket1 = new HashMap<>();
        for (int fruit : basket1)
            countInBasket1.merge(fruit, 1, Integer::sum);


        List<Integer> toSwap = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : totalCount.entrySet()) {
            int fruit = entry.getKey();
            int idealCount = entry.getValue() / 2;
            int count1 = countInBasket1.getOrDefault(fruit, 0);
            int diff = count1 - idealCount;

            for (int i = 0; i < Math.abs(diff); i++)
                toSwap.add(fruit);

        }

        Collections.sort(toSwap);
        long totalCost = 0;
        int swapsNeeded = toSwap.size() / 2;

        for (int i = 0; i < swapsNeeded; i++)
            totalCost += Math.min(toSwap.get(i), 2 * (long)minVal);

        return totalCost;
    }    
}
