package com.ds.array.medium;

public class TrappingRainWater {
    static long trappingWater(int arr[], int n) {
        // Your code here
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        long total = 0;

        while(left < right) {
            if(arr[left] < arr[right]) {
                leftMax = Integer.max(leftMax, arr[left]);
                total += (leftMax - arr[left]);
                left++;
            } else {
                rightMax = Integer.max(rightMax, arr[right]);
                total += (rightMax - arr[right]);
                right--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,0,2,0,4};
        long ans = trappingWater(nums, nums.length);
        System.out.println(ans);
    }
}
