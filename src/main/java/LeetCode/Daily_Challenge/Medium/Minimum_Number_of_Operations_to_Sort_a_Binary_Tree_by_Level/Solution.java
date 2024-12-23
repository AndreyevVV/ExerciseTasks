package LeetCode.Daily_Challenge.Medium.Minimum_Number_of_Operations_to_Sort_a_Binary_Tree_by_Level;

import java.util.*;

public class Solution {

    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        int operations = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            operations += countSwapsToSort(level);
        }

        return operations;
    }

    private int countSwapsToSort(List<Integer> level) {
        int n = level.size();
        int[] sorted = level.stream().mapToInt(i -> i).toArray();
        Arrays.sort(sorted);

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++)
            indexMap.put(level.get(i), i);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i] || level.get(i) == sorted[i])
                continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(sorted[j]);
                cycleSize++;
            }

            if (cycleSize > 1)
                swaps += (cycleSize - 1);
        }
        return swaps;
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
