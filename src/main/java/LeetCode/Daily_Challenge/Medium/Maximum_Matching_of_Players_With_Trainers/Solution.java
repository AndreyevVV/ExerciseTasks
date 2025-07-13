package LeetCode.Daily_Challenge.Medium.Maximum_Matching_of_Players_With_Trainers;

import java.util.Arrays;

public class Solution {
    
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, matches = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++;
                j++;
            } else
                j++;
        }

        return matches;
    }
}
