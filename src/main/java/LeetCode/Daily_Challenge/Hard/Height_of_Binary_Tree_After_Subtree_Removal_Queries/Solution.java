package LeetCode.Daily_Challenge.Hard.Height_of_Binary_Tree_After_Subtree_Removal_Queries;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<Integer, Integer> nodeIndexMap = new HashMap<>();
    private final Map<Integer, Integer> heightMap = new HashMap<>();
    private final Map<Integer, Integer> subtreeSizeMap = new HashMap<>();
    private int currentId = 0;

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] result = new int[queries.length];

        computeHeightsAndSubtreeSizes(root, 0);

        int[] leftMaxHeight = new int[currentId];
        int[] rightMaxHeight = new int[currentId];

        for (int i = 0; i < currentId; i++) {
            leftMaxHeight[i] = heightMap.get(i);
            if (i > 0) leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], leftMaxHeight[i]);
        }

        for (int i = currentId - 1; i >= 0; i--) {
            rightMaxHeight[i] = heightMap.get(i);
            if (i + 1 < currentId) rightMaxHeight[i] = Math.max(rightMaxHeight[i], rightMaxHeight[i + 1]);
        }

        for (int i = 0; i < queries.length; i++) {
            int nodeId = nodeIndexMap.get(queries[i]);
            int leftBoundary = nodeId;
            int rightBoundary = nodeId + subtreeSizeMap.get(nodeId) - 1;

            int maxHeightOutsideSubtree = 0;
            if (leftBoundary > 0) maxHeightOutsideSubtree = Math.max(maxHeightOutsideSubtree, leftMaxHeight[leftBoundary - 1]);
            if (rightBoundary + 1 < currentId) maxHeightOutsideSubtree = Math.max(maxHeightOutsideSubtree, rightMaxHeight[rightBoundary + 1]);

            result[i] = maxHeightOutsideSubtree;
        }

        return result;
    }

    private int computeHeightsAndSubtreeSizes(TreeNode node, int height) {
        if (node == null) return 0;

        nodeIndexMap.put(node.val, currentId);
        heightMap.put(currentId, height);
        currentId++;

        int leftSubtreeSize = computeHeightsAndSubtreeSizes(node.left, height + 1);
        int rightSubtreeSize = computeHeightsAndSubtreeSizes(node.right, height + 1);

        int subtreeSize = 1 + leftSubtreeSize + rightSubtreeSize;
        subtreeSizeMap.put(nodeIndexMap.get(node.val), subtreeSize);

        return subtreeSize;
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

