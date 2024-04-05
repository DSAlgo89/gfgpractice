package com.ds.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExists {
    private static boolean is_Possible(int[][] grid) {
        int startR = 0;
        int startC = 0;
        int endR = 0;
        int endC = 0;

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                }
                if(grid[i][j] == 2) {
                    endR = i;
                    endC = j;
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        visited[startR][startC] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});

        while(!queue.isEmpty()) {
            int[] rem = queue.poll();
            if(rem[0] == endR && rem[1] == endC)
                return true;

            for(int i = 0; i < directions.length; i++) {
                int newR = rem[0] + directions[i][0];
                int newC = rem[1] + directions[i][1];
                if(newR < 0 || newR >= m || newC < 0 || newC >= n
                        || visited[newR][newC] || grid[newR][newC] == 0)
                    continue;
                queue.add(new int[]{newR, newC});
                visited[newR][newC] = true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
