package LeetCode.Daily_Challenge.Easy.Number_of_Senior_Citizens;

public class Solution {

    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60)
                count++;
        }
        return count;
    }
}
