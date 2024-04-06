package com.ds.graph.medium;

public class UnitAreaOfLargestOnes {

    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
    private static int currentCount = 0;

    private static int findMaxArea(int[][] grid) {
        // Code here
        int m = grid.length;
        int n= grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxCount = 0;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    currentCount = 0;
                    dfs(grid, i, j, visited, m, n);
                    maxCount = Integer.max(maxCount, currentCount);
                }
            }
        }
        return maxCount;
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j])
            return;
        visited[i][j] = true;
        currentCount++;
        for(int k = 0; k < dirs.length; k++) {
            int newI = i + dirs[k][0];
            int newJ = j + dirs[k][1];
            dfs(grid, newI, newJ, visited, m, n);
        }
    }


    public static void main(String[] args) {

    }
}
