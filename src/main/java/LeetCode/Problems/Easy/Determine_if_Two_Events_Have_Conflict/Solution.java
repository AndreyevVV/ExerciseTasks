package LeetCode.Problems.Easy.Determine_if_Two_Events_Have_Conflict;

public class Solution {

    public boolean haveConflict(String[] event1, String[] event2) {
        int[] e1 = {Integer.parseInt(event1[0].substring(0,2)) * 60 + Integer.parseInt(event1[0].substring(3,5)),
                    Integer.parseInt(event1[1].substring(0,2)) * 60 + Integer.parseInt(event1[1].substring(3,5))};
        int[] e2 = {Integer.parseInt(event2[0].substring(0,2)) * 60 + Integer.parseInt(event2[0].substring(3,5)),
                    Integer.parseInt(event2[1].substring(0,2)) * 60 + Integer.parseInt(event2[1].substring(3,5))};

        return !(e1[1] < e2[0] || e2[1] < e1[0]);
    }
}
