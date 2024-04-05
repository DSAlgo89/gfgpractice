package com.ds.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CovidSpread {
    public static int helpaterp(int[][] hospital) {
        // code here
        int m = hospital.length;
        int n = hospital[0].length;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(hospital[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        int count = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for(int j = 0; j < directions.length; j++) {
                    int newR = pos[0] + directions[j][0];
                    int newC = pos[1] + directions[j][1];

                    if(newR < 0 || newR >= m || newC < 0 || newC >= n || hospital[newR][newC] != 1)
                        continue;
                    hospital[newR][newC] = 2;
                    queue.add(new int[]{newR, newC});
                }
            }
            count++;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(hospital[i][j] == 1)
                    return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
