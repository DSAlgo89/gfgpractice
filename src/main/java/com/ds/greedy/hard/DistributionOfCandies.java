package com.ds.greedy.hard;


import java.util.Arrays;

public class DistributionOfCandies {
    static public int distributeCandies(int[] nums) {
        // Code here
        int n = nums.length;
        int[] left = new int[n];
        Arrays.fill(left, 1);

        int[] right = new int[n];
        Arrays.fill(right, 1);

        for(int i = 1; i < n; i++) {
            if(nums[i - 1] < nums[i]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] > nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int total = 0;
        for(int i = 0; i < n; i++) {
            total += Integer.max(left[i], right[i]);
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
