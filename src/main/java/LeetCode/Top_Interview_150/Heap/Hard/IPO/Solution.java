package LeetCode.Top_Interview_150.Heap.Hard.IPO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++)
            projects[i] = new Project(profits[i], capital[i]);

        Arrays.sort(projects, Comparator.comparingInt(a -> a.capital));

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        int currentIndex = 0;

        for (int i = 0; i < k; i++) {
            while (currentIndex < n && projects[currentIndex].capital <= w) {
                heap.offer(projects[currentIndex].profit);
                currentIndex++;
            }

            if (!heap.isEmpty())
                w += heap.poll();
            else
                break;
        }

        return w;
    }

    class Project {
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
