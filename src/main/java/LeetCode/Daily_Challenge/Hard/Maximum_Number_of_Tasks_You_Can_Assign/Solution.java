package LeetCode.Daily_Challenge.Hard.Maximum_Number_of_Tasks_You_Can_Assign;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length, workers.length);

        while (left < right) {
            int mid = (left + right + 1) / 2;
            int usedPills = 0;
            TreeMap<Integer, Integer> availableWorkers = new TreeMap<>();

            for (int i = workers.length - mid; i < workers.length; ++i)
                availableWorkers.put(workers[i], availableWorkers.getOrDefault(workers[i], 0) + 1);

            boolean canAssign = true;

            for (int i = mid - 1; i >= 0; --i) {
                int required = tasks[i];

                Integer strongest = availableWorkers.lastKey();
                if (strongest >= required)
                    decrement(availableWorkers, strongest);
                else {
                    Integer boosted = availableWorkers.ceilingKey(required - strength);
                    if (boosted == null || ++usedPills > pills) {
                        canAssign = false;
                        break;
                    }
                    decrement(availableWorkers, boosted);
                }
            }

            if (canAssign)
                left = mid;
            else
                right = mid - 1;
        }

        return left;
    }

    private void decrement(TreeMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1)
            map.remove(key);
        else
            map.put(key, map.get(key) - 1);
    }
}
