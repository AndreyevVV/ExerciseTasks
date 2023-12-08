package LeetCode.Top_Interview_150.Backtracking.Medium.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, new ArrayList<>(), n, k, 1);
        return list;
    }

    private void backTrack(List<List<Integer>> list, List<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k)
            list.add(new ArrayList<>(tempList));
        else {
            for (int num = start; num <= n; num++) {
                tempList.add(num);
                backTrack(list, tempList, n, k, num + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

