package LeetCode.Daily_Challenge.Medium.Tuple_with_Same_Product;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length, result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        for (int count : productCount.values())
            if (count > 1)
                result += (count * (count - 1) / 2) * 8;

        return result;
    }
}
