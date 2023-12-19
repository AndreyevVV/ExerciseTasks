package LeetCode.Top_Interview_150.Divide_And_Conquer.Medium.Construct_Quad_Tree;

public class Solution {

    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructQuadTree(grid, 0, 0, n - 1, n - 1);
    }

    private Node constructQuadTree(int[][] grid, int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowStart == rowEnd && colStart == colEnd)
            return new Node(grid[rowStart][colStart] == 1, true);

        int midRow = (rowStart + rowEnd) / 2;
        int midCol = (colStart + colEnd) / 2;

        Node topLeft = constructQuadTree(grid, rowStart, colStart, midRow, midCol);
        Node topRight = constructQuadTree(grid, rowStart, midCol + 1, midRow, colEnd);
        Node bottomLeft = constructQuadTree(grid, midRow + 1, colStart, rowEnd, midCol);
        Node bottomRight = constructQuadTree(grid, midRow + 1, midCol + 1, rowEnd, colEnd);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val)
            return new Node(topLeft.val, true);
        else
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
