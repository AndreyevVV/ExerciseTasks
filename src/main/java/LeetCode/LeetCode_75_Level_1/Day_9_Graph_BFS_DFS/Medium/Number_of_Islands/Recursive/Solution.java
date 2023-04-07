package LeetCode.LeetCode_75_Level_1.Day_9_Graph_BFS_DFS.Medium.Number_of_Islands.Recursive;

public class Solution {

    public int numIslands(char[][] grid) {

        int ans = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int sr, int sc) {

        if (sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] != '1') return;

        grid[sr][sc] = '0';

        dfs(grid, sr + 1, sc);
        dfs(grid, sr - 1, sc);
        dfs(grid, sr, sc + 1);
        dfs(grid, sr, sc - 1);
    }
}
