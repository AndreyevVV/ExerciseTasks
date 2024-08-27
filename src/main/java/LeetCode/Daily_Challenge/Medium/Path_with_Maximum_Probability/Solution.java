package LeetCode.Daily_Challenge.Medium.Path_with_Maximum_Probability;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            graph.get(a).add(new Pair(b, prob));
            graph.get(b).add(new Pair(a, prob));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start_node, 1.0));

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double prob = current.prob;

            if (node == end_node) return prob;

            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                double nextProb = prob * neighbor.prob;

                if (nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = nextProb;
                    pq.add(new Pair(nextNode, nextProb));
                }
            }
        }

        return 0.0;
    }

    class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
