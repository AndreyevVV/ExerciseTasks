package LeetCode.Daily_Challenge.Medium.Most_Beautiful_Item_for_Each_Query;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        int[][] queriesWithIndices = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndices[i][0] = queries[i];
            queriesWithIndices[i][1] = i;
        }
        Arrays.sort(queriesWithIndices, Comparator.comparingInt(a -> a[0]));

        int[] answer = new int[queries.length];
        int maxBeauty = 0;
        int index = 0;

        for (int[] query : queriesWithIndices) {
            int price = query[0];
            int originalIndex = query[1];

            while (index < items.length && items[index][0] <= price) {
                maxBeauty = Math.max(maxBeauty, items[index][1]);
                index++;
            }

            answer[originalIndex] = maxBeauty;
        }

        return answer;
    }
}
