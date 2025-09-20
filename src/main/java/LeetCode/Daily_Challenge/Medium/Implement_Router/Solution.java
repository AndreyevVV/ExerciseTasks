package LeetCode.Daily_Challenge.Medium.Implement_Router;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    
    class Router {
        private int memoryLimit;
        private Queue<int[]> queue; 
        private Set<String> packetSet; 
        private Map<Integer, TreeMap<Integer, Integer>> destCount;
        private Map<Integer, TreeMap<Integer, Integer>> destPrefix;

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            this.queue = new ArrayDeque<>();
            this.packetSet = new HashSet<>();
            this.destCount = new HashMap<>();
            this.destPrefix = new HashMap<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            String key = source + "#" + destination + "#" + timestamp;
            if (packetSet.contains(key)) return false;

            if (queue.size() == memoryLimit) {
                int[] old = queue.poll();
                String oldKey = old[0] + "#" + old[1] + "#" + old[2];
                packetSet.remove(oldKey);
                updateCount(old[1], old[2], -1);
            }

            int[] packet = new int[]{source, destination, timestamp};
            queue.offer(packet);
            packetSet.add(key);
            updateCount(destination, timestamp, 1);

            return true;
        }

        public int[] forwardPacket() {
            if (queue.isEmpty()) return new int[0];
            int[] packet = queue.poll();

            String key = packet[0] + "#" + packet[1] + "#" + packet[2];
            packetSet.remove(key);
            updateCount(packet[1], packet[2], -1);

            return packet;
        }

        public int getCount(int destination, int startTime, int endTime) {
            if (!destPrefix.containsKey(destination)) return 0;
            TreeMap<Integer, Integer> prefix = destPrefix.get(destination);

            Integer endKey = prefix.floorKey(endTime);
            Integer startKey = prefix.floorKey(startTime - 1);

            int endSum = (endKey == null ? 0 : prefix.get(endKey));
            int startSum = (startKey == null ? 0 : prefix.get(startKey));

            return endSum - startSum;
        }

        private void updateCount(int dest, int time, int delta) {
            destCount.putIfAbsent(dest, new TreeMap<>());
            destPrefix.putIfAbsent(dest, new TreeMap<>());

            TreeMap<Integer, Integer> countMap = destCount.get(dest);
            TreeMap<Integer, Integer> prefixMap = destPrefix.get(dest);

            int newCount = countMap.getOrDefault(time, 0) + delta;
            if (newCount == 0)
                countMap.remove(time);
            else
                countMap.put(time, newCount);

            Integer prevKey = prefixMap.lowerKey(time);
            int prevSum = (prevKey == null ? 0 : prefixMap.get(prevKey));
            int curCount = countMap.getOrDefault(time, 0);
            prefixMap.put(time, prevSum + curCount);

            Integer higher = prefixMap.higherKey(time);
            int running = prefixMap.get(time);
            while (higher != null) {
                running += countMap.getOrDefault(higher, 0);
                prefixMap.put(higher, running);
                higher = prefixMap.higherKey(higher);
            }
        }
    }
}
