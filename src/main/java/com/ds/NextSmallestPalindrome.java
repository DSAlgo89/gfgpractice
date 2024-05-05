package com.ds;

import java.util.Arrays;

public class NextSmallestPalindrome {
    private static void nextSmallestPalindrome(int[] nums) {
        if(isAll9(nums)) {
            int len = nums.length;
            nums = new int[len + 1];
            nums[0] = 1;
            nums[len] = 1;
            return;
        }

        int n = nums.length;
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid: mid + 1;
        boolean leftSmaller = false;

        while(i >= 0 && j < n && nums[i] == nums[j]) {
            i--;
            j++;
        }

        if(i < 0 || nums[i] < nums[j]) {
            leftSmaller = true;
        }

        while(i >= 0) {
            nums[j] = nums[i];
            i--;
            j++;
        }

        if(leftSmaller) {
            int carry = 1;

            if(n % 2 != 0) {
                nums[mid] += carry;
                carry = nums[mid] / 10;
                nums[mid] = nums[mid] % 10;
            }

            i = mid - 1;
            j = (n % 2 != 0) ? mid + 1: mid;

            while(i >= 0 && carry > 0) {
                nums[i] = nums[i] + carry;
                carry = nums[i] / 10;
                nums[i] = nums[i] % 10;
                nums[j] = nums[i];
                i--;
                j++;
            }
        }
    }

    private static boolean isAll9(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 9)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
        nextSmallestPalindrome(nums);

        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,3,3,1};
        nextSmallestPalindrome(nums);

        System.out.println(Arrays.toString(nums));
    }
}
