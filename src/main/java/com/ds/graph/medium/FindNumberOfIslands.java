package com.ds.graph.medium;

public class FindNumberOfIslands {
    private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};

    public static int numIslands(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j, m, n);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j])
            return;
        visited[i][j] = true;
        for(int k = 0; k < directions.length; k++) {
            int newR = i + directions[k][0];
            int newC = j + directions[k][1];
            dfs(grid, visited, newR, newC, m, n);
        }
    }


    public static void main(String[] args) {

    }
}
