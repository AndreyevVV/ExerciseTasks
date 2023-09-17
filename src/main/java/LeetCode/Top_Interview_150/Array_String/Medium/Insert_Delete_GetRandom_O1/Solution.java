package LeetCode.Top_Interview_150.Array_String.Medium.Insert_Delete_GetRandom_O1;

import java.util.*;

public class Solution {

    class RandomizedSet {
        private Map<Integer, Integer> valToIndex;
        private List<Integer> values;
        private Random rand;

        public RandomizedSet() {
            valToIndex = new HashMap<>();
            values = new ArrayList<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val))
                return false;
            values.add(val);
            valToIndex.put(val, values.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val))
                return false;

            int indexToRemove = valToIndex.get(val);
            int lastValue = values.get(values.size() - 1);

            values.set(indexToRemove, lastValue);
            valToIndex.put(lastValue, indexToRemove);

            values.remove(values.size() - 1);
            valToIndex.remove(val);

            return true;
        }

        public int getRandom() {
            int randomIndex = rand.nextInt(values.size());
            return values.get(randomIndex);
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
