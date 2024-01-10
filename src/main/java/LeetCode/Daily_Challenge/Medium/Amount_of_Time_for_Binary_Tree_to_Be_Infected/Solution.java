package LeetCode.Daily_Challenge.Medium.Amount_of_Time_for_Binary_Tree_to_Be_Infected;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().start());
    }

    private int start() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.right.right = new TreeNode(2);

        int start = 3;
        int minutes = amountOfTime(root, start);

        System.out.println("Minutes needed for the entire tree to be infected: " + minutes);

        return minutes;
    }

    public int amountOfTime(TreeNode root, int start) {
        List<UndirectedGraphNode> graph = convertToUndirectedGraph(root);
        return minutesToInfect(graph, start);
    }

    private List<UndirectedGraphNode> convertToUndirectedGraph(TreeNode root) {
        Map<TreeNode, UndirectedGraphNode> nodeToGraphMap = new HashMap<>();
        List<UndirectedGraphNode> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            UndirectedGraphNode graphNode = nodeToGraphMap.computeIfAbsent(current,
                    k -> new UndirectedGraphNode(k.val));
            result.add(graphNode);

            if (current.left != null) {
                UndirectedGraphNode leftGraphNode = nodeToGraphMap.computeIfAbsent(current.left,
                        k -> new UndirectedGraphNode(k.val));
                graphNode.neighbors.add(leftGraphNode);
                leftGraphNode.neighbors.add(graphNode);
                queue.add(current.left);
            }

            if (current.right != null) {
                UndirectedGraphNode rightGraphNode = nodeToGraphMap.computeIfAbsent(current.right,
                        k -> new UndirectedGraphNode(k.val));
                graphNode.neighbors.add(rightGraphNode);
                rightGraphNode.neighbors.add(graphNode);
                queue.add(current.right);
            }
        }

        return result;
    }

    private int minutesToInfect(List<UndirectedGraphNode> graph, int start) {
        if (graph == null || graph.isEmpty())
            return 0;

        UndirectedGraphNode startNode = findNode(graph, start);

        if (startNode == null)
            return 0;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, Integer> distances = new HashMap<>();

        queue.add(startNode);
        distances.put(startNode, 0);

        int maxTime = 0;

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            int currentDistance = distances.get(current);

            maxTime = Math.max(maxTime, currentDistance);

            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, currentDistance + 1);
                    queue.add(neighbor);
                }
            }
        }

        return maxTime;
    }

    private UndirectedGraphNode findNode(List<UndirectedGraphNode> graph, int value) {
        for (UndirectedGraphNode node : graph)
            if (node.val == value)
                return node;

        return null;
    }

    class UndirectedGraphNode {
        int val;
        List<UndirectedGraphNode> neighbors;

        public UndirectedGraphNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
