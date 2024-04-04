package com.ds.array.easy;

import java.util.Arrays;

public class RotateArray {
    static void rotateArr(int arr[], int d, int n) {
        if(d > n) {
            d = d % n;
        }
        // add your code here
        rotate(arr, 0, d - 1);
        rotate(arr, d, n - 1);
        rotate(arr, 0, n - 1);
    }

    private static void rotate(int[] arr, int start, int end) {
        while(start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        rotateArr(nums, 2, nums.length);

        System.out.println(Arrays.toString(nums));
    }
}
