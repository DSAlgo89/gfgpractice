package com.ds.array.medium;

public class MaximumIndex {
    static int maxIndexDiff(int a[], int n) {

        // Your code here
        int[] minL = new int[n];
        int[] maxR = new int[n];

        minL[0] = a[0];
        for(int i = 1; i < n; i++) {
            minL[i] = Integer.min(minL[i - 1], a[i]);
        }

        maxR[n - 1] = a[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            maxR[i] = Integer.max(maxR[i + 1], a[i]);
        }

        int i = 0;
        int j = 0;
        int maxDiff = 0;
        while(i < n && j < n) {
            if(minL[i] <= maxR[j]) {
                maxDiff = Integer.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] nums = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiff(nums, nums.length));
    }
}
