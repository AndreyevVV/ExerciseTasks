package LeetCode.Daily_Challenge.Easy.N_ary_Tree_Postorder_Traversal.Iterative_solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> postorder(Node root) {
        Stack<Integer> stack = new Stack<>();
        if (root == null) return new ArrayList<>();

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            Node current = nodeStack.pop();
            stack.push(current.val);

            for (Node child : current.children)
                nodeStack.push(child);
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
