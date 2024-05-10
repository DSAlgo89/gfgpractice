package com.ds.stack;

public class MaxRectangle {
    private static int maxArea(int M[][], int n, int m) {
        // add code here.
        int[][] dp = new int[n][m];

        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(M[i][j] == 1) {
                    dp[i][j] = (j == 0) ? 1: 1 + dp[i][j - 1];

                    int width = dp[i][j];
                    for(int k = i; k >= 0; k--) {
                        width = Integer.min(dp[k][j], width);
                        int height = (i - k) + 1;
                        maxArea = Integer.max(maxArea, height * width);
                    }
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] M = {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        System.out.println(maxArea(M, 4, 4));
    }
}
