package LeetCode.LeetCode_75_Level_1.Day_9_Graph_BFS_DFS.Easy.Flood_Fill;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) return image;

        int initColor = image[sr][sc];

        dfs(image, sr, sc, initColor, color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int initColor, int color) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != initColor) return;

        image[sr][sc] = color;

        dfs(image, sr + 1, sc, initColor, color);
        dfs(image, sr - 1, sc, initColor, color);
        dfs(image, sr, sc + 1, initColor, color);
        dfs(image, sr, sc - 1, initColor, color);
    }
}
