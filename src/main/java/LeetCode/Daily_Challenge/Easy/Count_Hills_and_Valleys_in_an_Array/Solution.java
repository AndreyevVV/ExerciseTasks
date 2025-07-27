package LeetCode.Daily_Challenge.Easy.Count_Hills_and_Valleys_in_an_Array;

public class Solution {

    public int countHillValley(int[] nums) {
        int n = nums.length;
        int count = 0;

        int[] filtered = new int[n];
        int m = 0;
        filtered[m++] = nums[0];
        for (int i = 1; i < n; i++)
            if (nums[i] != nums[i - 1])
                filtered[m++] = nums[i];
        
        for (int i = 1; i < m - 1; i++) {
            if (filtered[i] > filtered[i - 1] && filtered[i] > filtered[i + 1])
                count++;
         else if (filtered[i] < filtered[i - 1] && filtered[i] < filtered[i + 1])
                count++;
        }

        return count;
    }    
}
