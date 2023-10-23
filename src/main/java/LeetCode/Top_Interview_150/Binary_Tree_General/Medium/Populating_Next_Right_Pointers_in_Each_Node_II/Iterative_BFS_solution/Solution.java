package LeetCode.Top_Interview_150.Binary_Tree_General.Medium.Populating_Next_Right_Pointers_in_Each_Node_II.Iterative_BFS_solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public Node connect(Node root) {
        if (root == null) return null;
        Node curr = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(curr);

        while (!queue.isEmpty()) {
            int elementsOnLevel = queue.size();
            Node tempLeft = new Node();

            for (int i = 0; i < elementsOnLevel; i++) {
                curr = queue.poll();
                tempLeft.next = curr;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                tempLeft = curr;
            }
            tempLeft.next = null;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
