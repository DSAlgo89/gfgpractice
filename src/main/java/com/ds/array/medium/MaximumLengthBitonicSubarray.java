package com.ds.array.medium;

public class MaximumLengthBitonicSubarray {
    static int bitonic(int[] arr, int n) {
        // code here
        int[] lis = new int[n];
        int[] lds = new int[n];

        lis[0] = 1;

        for(int i = 1; i < n; i++) {
            lis[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    lis[i] = Integer.max(lis[i], lis[j] + 1);
                }
            }
        }

        lds[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            lds[i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[i]) {
                    lds[i] = Integer.max(lds[i], lds[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Integer.max(max, lis[i] + lds[i] - 1);
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
