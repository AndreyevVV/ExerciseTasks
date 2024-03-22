package LeetCode.Problems.Easy.Design_HashSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    class MyHashSet {
        private final int numBuckets = 1000;
        private final List<List<Integer>> buckets;

        public MyHashSet() {
            buckets = new ArrayList<>(numBuckets);

            for (int i = 0; i < numBuckets; i++)
                buckets.add(null);
        }

        private int hashFunction(int key) {
            return key % numBuckets;
        }

        public void add(int key) {
            int index = hashFunction(key);
            List<Integer> bucket = buckets.get(index);

            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets.set(index, bucket);
            }

            if (!bucket.contains(key))
                bucket.add(key);
        }

        public void remove(int key) {
            int index = hashFunction(key);
            List<Integer> bucket = buckets.get(index);

            if (bucket != null)
                bucket.remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            int index = hashFunction(key);
            List<Integer> bucket = buckets.get(index);
            return bucket != null && bucket.contains(key);
        }
    }
}
