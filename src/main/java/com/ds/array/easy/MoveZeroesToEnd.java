package com.ds.array.easy;

import java.util.Arrays;

public class MoveZeroesToEnd {
    static void pushZerosToEnd(int[] arr, int n) {
        // code here
        int i = -1;
        for(int j = 0; j < n; j++) {
            if(arr[j] != 0) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 0, 0, 4};
        pushZerosToEnd(nums, nums.length);

        System.out.println(Arrays.toString(nums));
    }
}
