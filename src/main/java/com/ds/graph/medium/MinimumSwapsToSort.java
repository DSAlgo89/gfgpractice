package com.ds.graph.medium;

import java.util.Arrays;

public class MinimumSwapsToSort {
    private static int minSwaps(int nums[]) {
        // Code here
        int[] temp = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp);
        int notCorrectPosCnt = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != temp[i]) {
                notCorrectPosCnt++;
            }
        }
        if(notCorrectPosCnt % 2 != 0) {
            notCorrectPosCnt++;
        }
        return notCorrectPosCnt/2;
    }
    public static void main(String[] args) {

    }
}
