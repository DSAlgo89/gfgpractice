package com.ds.array.easy;

import java.util.Arrays;

public class PrintUnsorted {
    static int[] printUnsorted(int[] arr, int n) {
        // code here
        //int rightDisturbedIndx = -1;
        int i = n - 2;
        while(i >= 0 && arr[i] < arr[i + 1]) {
            i--;
        }

        if(i == 0)
            return new int[]{0,0};
        int right = i;
        int end = 0;
        i = n - 1;
        while(i >= right) {
            if(arr[i] < arr[right]) {
                end = i;
                break;
            }
            i--;
        }

        i = 1;
        while(i < n && arr[i - 1] < arr[i]) {
            i++;
        }

        int left = i;
        i = 0;
        int start = 0;
        while(i <= left) {
            if(arr[i] > arr[left]) {
                start = i;
                break;
            }
            i++;
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] nums = {10,12,20,30,25,40,32,31,35,50,60};
        System.out.println(Arrays.toString(printUnsorted(nums, nums.length)));

        nums = new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50};
        System.out.println(Arrays.toString(printUnsorted(nums, nums.length)));
    }
}
