package com.ds.array.easy;

public class RemoveDuplicateElementFromSortedArray {
    static int remove_duplicate(int A[],int N){
        // code here
        int i = 0;
        while(i < N) {
            int j = i + 1;
            while(j < N && A[i] == A[j]) {
                j++;
            }

            if(j - i > 1) {
                int k = i + 1;
                while(k < j) {
                    A[k++] = Integer.MAX_VALUE;
                }
            }
            i = j;
        }

        i = -1;
        for(int j = 0; j < N; j++) {
            if(A[j] != Integer.MAX_VALUE) {
                i++;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return (i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(remove_duplicate(nums, nums.length));
    }
}
