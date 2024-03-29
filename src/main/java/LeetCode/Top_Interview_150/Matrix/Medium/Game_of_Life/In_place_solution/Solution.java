package LeetCode.Top_Interview_150.Matrix.Medium.Game_of_Life.In_place_solution;

public class Solution {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)
                        if (board[newRow][newCol] == 1 || board[newRow][newCol] == -1)
                            liveNeighbors++;
                }

                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3))
                    board[i][j] = -1;

                if (board[i][j] == 0 && liveNeighbors == 3)
                    board[i][j] = 2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1)
                    board[i][j] = 0;
                else if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
}
