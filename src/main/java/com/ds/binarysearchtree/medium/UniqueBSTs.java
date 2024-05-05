package com.ds.binarysearchtree.medium;

public class UniqueBSTs {
    static final int MOD = 1000000007;

    static int numTrees(int N)
    {
        // Your code goes here
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = (dp[i] + ((dp[j] % MOD) * (dp[i - j - 1] % MOD)) % MOD) % MOD;
            }
        }

        return dp[N];

    }

    public static void main(String[] args) {

    }
}
