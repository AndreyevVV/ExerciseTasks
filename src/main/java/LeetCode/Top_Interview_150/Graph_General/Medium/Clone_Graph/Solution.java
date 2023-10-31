package LeetCode.Top_Interview_150.Graph_General.Medium.Clone_Graph;

import java.util.*;

public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> nodeMap = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Node newNode = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, newNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    Node newNeighbor = new Node(neighbor.val, new ArrayList<>());
                    nodeMap.put(neighbor, newNeighbor);
                    queue.add(neighbor);
                }
                nodeMap.get(current).neighbors.add(nodeMap.get(neighbor));
            }
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
