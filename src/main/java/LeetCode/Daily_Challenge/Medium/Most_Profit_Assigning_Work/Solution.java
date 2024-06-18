package LeetCode.Daily_Challenge.Medium.Most_Profit_Assigning_Work;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        System.out.println(solution.maxProfitAssignment(difficulty, profit, worker));
    }


    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++)
            jobs.add(new Job(difficulty[i], profit[i]));

        jobs.sort(Comparator.comparingInt(Job::getDifficulty).thenComparingInt(Job::getProfit));

        Arrays.sort(worker);

        PriorityQueue<Job> queue = new PriorityQueue<>((a, b) -> b.getProfit() - a.getProfit());

        int maxProfit = 0;
        int jobIndex = 0;
        for (int ability : worker) {
            while (jobIndex < jobs.size() && jobs.get(jobIndex).getDifficulty() <= ability) {
                queue.add(jobs.get(jobIndex));
                jobIndex++;
            }

            if (!queue.isEmpty())
                maxProfit += queue.peek().getProfit();
        }
        return maxProfit;
    }

    private static class Job {
        private final int difficulty;

        private final int profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public int getProfit() {
            return profit;
        }

    }
}
