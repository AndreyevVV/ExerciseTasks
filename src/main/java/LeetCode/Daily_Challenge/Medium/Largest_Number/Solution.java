package LeetCode.Daily_Challenge.Medium.Largest_Number;

import java.util.Arrays;

public class Solution {

    public String largestNumber(int[] nums) {
        String[] strNums = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if (strNums[0].equals("0"))
            return "0";

        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums)
            largestNumber.append(num);

        return largestNumber.toString();
    }
}
