package LeetCode.Top_Interview_150.Array_String.Hard.Candy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int length = ratings.length;
        int[] candies = new int[length];

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] >  ratings[i + 1])
                if(candies[i] <= candies[i + 1])
                    candies[i] = candies[i + 1] + 1;
        }
        return Arrays.stream(candies).reduce(Integer::sum).getAsInt() + ratings.length;
    }
}
