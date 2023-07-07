package LeetCode.LeetCode_75.Array_String.Easy.Kids_With_the_Greatest_Number_of_Candies;

import java.util.*;

public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies.length <= 1) return List.of(true);
        int maxValue = Arrays.stream(candies).max().getAsInt();

        int criterion = maxValue - extraCandies;
        List<Boolean> answer = new ArrayList<>();

        for (int candiesPack : candies) {
            if (candiesPack >= criterion) answer.add(true);
            else answer.add(false);
        }
        return answer;
    }
}
