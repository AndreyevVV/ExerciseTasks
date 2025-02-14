package LeetCode.Daily_Challenge.Medium.Product_of_the_Last_K_Numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class ProductOfNumbers {
        private List<Integer> prefixProducts;

        public ProductOfNumbers() {
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                prefixProducts.clear();
                prefixProducts.add(1);
            } else
                prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
        }

        public int getProduct(int k) {
            int size = prefixProducts.size();
            if (k >= size) return 0;
            return prefixProducts.get(size - 1) / prefixProducts.get(size - 1 - k);
        }
    }
}
