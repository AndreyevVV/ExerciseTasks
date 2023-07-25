package LeetCode.LeetCode_75.Queue.Easy.Number_of_Recent_Calls;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class RecentCounter {
        private Queue<Integer> recentCounter;

        public RecentCounter() {
            this.recentCounter = new LinkedList<>();
        }

        public int ping(int t) {
            recentCounter.add(t);
            while (recentCounter.peek() < t - 3000) recentCounter.remove();
            return recentCounter.size();
        }
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */