package com.ds.array.medium;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {
    private static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int indx = -1;
        int i = 0;
        for(i = N - 2; i >= 0; i--) {
            if(arr[i] < arr[i + 1]) {
                indx = i;
                break;
            }
        }

        if(indx == - 1) {
            reverse(arr, 0, N - 1);
            return convertToList(arr);
        }

        for(i = N - 1; i > indx; i--) {
            if(arr[i] > arr[indx]) {
                swap(arr, i, indx);
                break;
            }
        }

        reverse(arr, indx + 1, N - 1);
        return convertToList(arr);
    }

    private static List<Integer> convertToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int num: arr) {
            list.add(num);
        }
        return list;
    }

    private static void reverse(int[] arr, int start, int end) {
        while(start <= end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Integer> result = nextPermutation(nums.length, nums);

        System.out.println(result);
    }
}
