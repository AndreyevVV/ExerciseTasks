package LeetCode.Daily_Challenge.Easy.Buy_Two_Chocolates;

import java.util.Arrays;

public class Solution {

    public int buyChoco(int[] prices, int money) {
        int minPrice1 = Integer.MAX_VALUE;
        int minPrice2 = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice1) {
                minPrice2 = minPrice1;
                minPrice1 = price;
            } else if (price < minPrice2)
                minPrice2 = price;
        }
        return money - minPrice1 - minPrice2 >= 0 ? money - minPrice1 - minPrice2 : money;
    }
}
