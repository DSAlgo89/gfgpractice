package com.ds.array.medium;

public class MaximizeNumberOfOnes {
    private static int findZeroes(int arr[], int n, int m) {
        // code here
        int right = 0;
        int left = 0;
        int maxLen = 0;
        int countZero = 0;

        while(right < n) {
            if(arr[right] == 0) {
                countZero++;
            }

            while(left <= right && countZero > m) {
                if(arr[left] == 0) {
                    countZero--;
                }
                left++;
            }

            //if(countZero == m) {
                maxLen = Integer.max(maxLen, (right - left + 1));
            //}
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        int m = 1;

        System.out.println(findZeroes(nums, nums.length, m));

        nums = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        m = 2;

        System.out.println(findZeroes(nums, nums.length, m));
    }
}
