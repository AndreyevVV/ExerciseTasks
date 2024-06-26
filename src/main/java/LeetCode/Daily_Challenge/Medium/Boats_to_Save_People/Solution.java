package LeetCode.Daily_Challenge.Medium.Boats_to_Save_People;

import java.util.Arrays;

public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit)
                left++;
            right--;
            boats++;
        }
        return boats;
    }
}
