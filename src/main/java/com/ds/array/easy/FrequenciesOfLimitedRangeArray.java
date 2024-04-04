package com.ds.array.easy;

import java.util.Arrays;

//video link:- https://www.youtube.com/watch?v=_yRjkMkTCA0
public class FrequenciesOfLimitedRangeArray {
    public static void frequencyCount(int arr[], int N, int P) {
        // code here
        for(int i = 0; i < N;) {
            if(arr[i] > 0 && arr[i] <= N) {
                int j = arr[i] - 1;
                if(arr[j] <= 0) {
                    arr[i] = 0;
                    arr[j]--;
                    i++;
                } else {
                    swap(arr, i, j);
                    arr[j] = -1;
                }
            } else if(arr[i] > N) {
                arr[i] = 0;
                i++;
            } else {
                i++;
            }
        }

        for(int i = 0; i < N; i++) {
            arr[i] = -arr[i];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 3, 5};
        int P = 5;
        frequencyCount(arr, arr.length, P);

        System.out.println(Arrays.toString(arr));
    }
}
