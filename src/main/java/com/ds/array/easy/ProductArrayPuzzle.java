package com.ds.array.easy;

import java.util.Arrays;

public class ProductArrayPuzzle {
    private static long[] productExceptSelf(int nums[], int n) {
        // code here
        long []leftArr = new long[n];
        long []rightArr = new long[n];
        long left = 1;
        for(int i = 0; i < n; i++) {
            leftArr[i] = left;
            left = left * nums[i];
        }

        long right = 1;
        for(int i = n - 1; i >= 0; i--) {
            rightArr[i] = right;
            right = right * nums[i];
        }

        for(int i = 0; i < n; i++) {
            leftArr[i] = leftArr[i] * rightArr[i];
        }
        return leftArr;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 6, 2};
        int n = 5;

        long[] ans = productExceptSelf(nums, n);
        System.out.println(Arrays.toString(ans));
    }
}
