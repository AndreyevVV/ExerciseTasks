package LeetCode.Daily_Challenge.Easy.N_ary_Tree_Postorder_Traversal.Recursive_solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(Node node, List<Integer> result) {
        if (node == null) return;

        for (Node child : node.children)
            postorderHelper(child, result);

        result.add(node.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
