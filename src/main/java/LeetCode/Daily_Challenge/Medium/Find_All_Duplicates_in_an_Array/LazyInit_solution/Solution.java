package LeetCode.Daily_Challenge.Medium.Find_All_Duplicates_in_an_Array.LazyInit_solution;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> res;

    public List<Integer> findDuplicates(int[] nums) {
        return new AbstractList<Integer>() {
            public Integer get(int index) {
                init();
                return res.get(index);
            }

            public int size() {
                init();
                return res.size();
            }

            private void init() {
                if (res != null) return;
                res = new ArrayList<>();
                int t;
                for (int i = 0; i < nums.length; i++) {
                    t = Math.abs(nums[i]);
                    if (nums[t - 1] < 0) {
                        res.add(t);
                    } else {
                        nums[t - 1] *= -1;
                    }
                }
            }
        };
    }
}
